package cn.bobasyu.cagesspringboot.service;

import cn.bobasyu.cagesspringboot.entity.OperationType;
import cn.bobasyu.cagesspringboot.entity.TimingTask;
import cn.bobasyu.cagesspringboot.entity.TimingTaskType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
public interface TimingTaskService {
    TimingTask findById(Integer id);

    List<TimingTask> findAll();

    List<TimingTask> findBetweenTimes(LocalDateTime from, LocalDateTime to);

    List<TimingTask> findByTimingTaskType(TimingTaskType timingTaskType);

    List<TimingTask> fndBtOperationType(OperationType operationType);

    int deleteById(Integer id);

    int insert(TimingTask timingTask);

    int update(TimingTask timingTask);
}
