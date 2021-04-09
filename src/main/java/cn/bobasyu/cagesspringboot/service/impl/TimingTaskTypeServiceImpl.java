package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.entity.TimingTaskType;
import cn.bobasyu.cagesspringboot.mapper.TimingTaskTypeMapper;
import cn.bobasyu.cagesspringboot.service.TimingTaskTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
@Service
public class TimingTaskTypeServiceImpl implements TimingTaskTypeService {
    private final TimingTaskTypeMapper timingTaskTypeMapper;

    @Autowired
    public TimingTaskTypeServiceImpl(TimingTaskTypeMapper timingTaskTypeMapper) {
        this.timingTaskTypeMapper = timingTaskTypeMapper;
    }

    @Override
    public TimingTaskType findById(Integer id) {
        return timingTaskTypeMapper.selectById(id);
    }

    @Override
    public List<TimingTaskType> findALl() {
        return timingTaskTypeMapper.selectList(null);
    }

    @Override
    public List<TimingTaskType> findBetweenTimes(LocalDateTime from, LocalDateTime to) {
        QueryWrapper<TimingTaskType> wrapper = new QueryWrapper<>();
        wrapper.select("id", "timing_Task_Type", "create_time")
                .between("create_time", from, to);
        return timingTaskTypeMapper.selectList(wrapper);
    }

    @Override
    public int update(TimingTaskType timingTaskType) {
        return timingTaskTypeMapper.updateById(timingTaskType);
    }

    @Override
    public int insert(TimingTaskType timingTaskType) {
        return timingTaskTypeMapper.insert(timingTaskType);
    }

    @Override
    public int deleteById(Integer id) {
        return timingTaskTypeMapper.deleteById(id);
    }
}
