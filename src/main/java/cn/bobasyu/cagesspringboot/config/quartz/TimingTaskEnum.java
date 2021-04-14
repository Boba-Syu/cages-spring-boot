package cn.bobasyu.cagesspringboot.config.quartz;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TimingTaskEnum {
    ONE_TIME(1, "一次性任务"),
    DAILY(2, "每日任务"),
    WEEKLY(3, "每周任务");

    private final int id;
    private final String name;
}
