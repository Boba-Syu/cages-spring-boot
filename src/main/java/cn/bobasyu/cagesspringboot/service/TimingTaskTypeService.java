package cn.bobasyu.cagesspringboot.service;

import cn.bobasyu.cagesspringboot.entity.TimingTaskType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
public interface TimingTaskTypeService {
    TimingTaskType findById(Integer id);

    List<TimingTaskType> findALl();

    List<TimingTaskType> findBetweenTimes(LocalDateTime from, LocalDateTime to);

    int update(TimingTaskType timingTaskType);

    int insert(TimingTaskType timingTaskType);

    int deleteById(Integer id);
}
