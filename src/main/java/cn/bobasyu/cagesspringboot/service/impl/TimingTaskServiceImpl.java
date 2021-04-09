package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.entity.OperationType;
import cn.bobasyu.cagesspringboot.entity.TimingTask;
import cn.bobasyu.cagesspringboot.entity.TimingTaskType;
import cn.bobasyu.cagesspringboot.mapper.TimingTaskMapper;
import cn.bobasyu.cagesspringboot.service.TimingTaskService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
@Service
public class TimingTaskServiceImpl implements TimingTaskService {
    private final TimingTaskMapper timingTaskMapper;

    @Autowired
    public TimingTaskServiceImpl(TimingTaskMapper timingTaskMapper) {
        this.timingTaskMapper = timingTaskMapper;
    }

    @Override
    public TimingTask findById(Integer id) {
        return timingTaskMapper.selectById(id);
    }

    @Override
    public List<TimingTask> findAll() {
        return timingTaskMapper.selectList(null);
    }

    @Override
    public List<TimingTask> findBetweenTimes(LocalDateTime from, LocalDateTime to) {
        QueryWrapper<TimingTask> wrapper = new QueryWrapper<>();
        wrapper.select("id", "operation_type", "create_time", "timing_task_type", "msg")
                .between("create_time", from, to);
        return timingTaskMapper.selectList(wrapper);
    }

    @Override
    public List<TimingTask> findByTimingTaskType(TimingTaskType timingTaskType) {
        QueryWrapper<TimingTask> wrapper = new QueryWrapper<>();
        wrapper.select("id", "operation_type", "create_time", "timing_task_type", "msg")
                .eq("timing_task_time", timingTaskType);
        return timingTaskMapper.selectList(wrapper);
    }

    @Override
    public List<TimingTask> fndBtOperationType(OperationType operationType) {
        QueryWrapper<TimingTask> wrapper = new QueryWrapper<>();
        wrapper.select("id", "operation_type", "create_time", "timing_task_type", "msg")
                .eq("operation_type", operationType);
        return timingTaskMapper.selectList(wrapper);
    }

    @Override
    public int deleteById(Integer id) {
        return timingTaskMapper.deleteById(id);
    }

    @Override
    public int insert(TimingTask timingTask) {
        return timingTaskMapper.insert(timingTask);
    }

    @Override
    public int update(TimingTask timingTask) {
        return timingTaskMapper.updateById(timingTask);
    }
}
