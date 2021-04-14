package cn.bobasyu.cagesspringboot.config.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.DateBuilder.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author bobasyu
 */
public class Schedule {
    private final Scheduler scheduler;

    public Schedule() throws SchedulerException {
        // 创建调度器
        this.scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
    }

    /**
     * 一次性的定时任务
     *
     * @param executeJob
     * @param executeTime
     * @throws SchedulerException
     */
    public void addOneTimeJob(InstructionJob executeJob, LocalDateTime executeTime) throws SchedulerException {
        int times = (int) Duration.between(LocalDateTime.now(), executeTime).toHours();
        JobDetail jobDetail = JobBuilder.newJob(executeJob.getClass())
                .withIdentity("job" + Math.random(), "group")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger" + Math.random(), "group")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(futureDate(times, IntervalUnit.HOUR))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 每日一次的定时任务
     *
     * @param executeJob
     * @param executeTime
     * @throws SchedulerException
     */
    public void addDailyJob(InstructionJob executeJob, LocalDateTime executeTime) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(executeJob.getClass())
                .withIdentity("job" + Math.random(), "group")
                .build();
        int hour = executeTime.getHour();
        int min = executeTime.getMinute();
        Trigger trigger = newTrigger()
                .withIdentity("trigger" + Math.random(), "group")
                .withSchedule(dailyAtHourAndMinute(hour, min))
                .forJob(jobDetail)
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public void addWeeklyJob(InstructionJob executeJob, LocalDateTime executeTime) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(executeJob.getClass())
                .withIdentity("job" + Math.random(), "group")
                .build();
        DayOfWeek week = executeTime.getDayOfWeek();
        int hour = executeTime.getHour();
        int min = executeTime.getMinute();
        String str = "0 " + min + " " + hour + " * * ";
        switch (week) {
            case MONDAY:
                str += "MON";
            case TUESDAY:
                str += "TUE";
            case WEDNESDAY:
                str += "WED";
            case THURSDAY:
                str += "THU";
            case FRIDAY:
                str += "FRI";
            case SATURDAY:
                str += "SAT";
            case SUNDAY:
                str += "SUN";
        }
        Trigger trigger = newTrigger()
                .withIdentity("trigger" + Math.random(), "group")
                .withSchedule(cronSchedule(str))
                .forJob(jobDetail)
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
