package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.entity.Temperature;
import cn.bobasyu.cagesspringboot.mapper.TemperatureMapper;
import cn.bobasyu.cagesspringboot.service.TemperatureService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
@Service
public class TemperatureServiceImpl implements TemperatureService {
    private final TemperatureMapper temperatureMapper;

    @Autowired
    public TemperatureServiceImpl(TemperatureMapper temperatureMapper) {
        this.temperatureMapper = temperatureMapper;
    }

    @Override
    public Temperature findById(Integer id) {
        return temperatureMapper.selectById(id);
    }

    @Override
    public List<Temperature> findAll() {
        return temperatureMapper.selectList(null);
    }

    @Override
    public List<Temperature> findBetweenTimes(LocalDateTime before, LocalDateTime to) {
        QueryWrapper<Temperature> wrapper = new QueryWrapper<>();
        wrapper.select("id", "temperature", "create_time")
                .between("create_time", before, to);
        return temperatureMapper.selectList(wrapper);
    }

    @Override
    public int insert(Temperature temperature) {
        return temperatureMapper.insert(temperature);
    }

    @Override
    public int deleteById(Integer id) {
        return temperatureMapper.deleteById(id);
    }

    @Override
    public int update(Temperature temperature) {
        return temperatureMapper.updateById(temperature);
    }
}
