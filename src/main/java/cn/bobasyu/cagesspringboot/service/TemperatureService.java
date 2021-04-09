package cn.bobasyu.cagesspringboot.service;

import cn.bobasyu.cagesspringboot.entity.Temperature;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
public interface TemperatureService {
    Temperature findById(Integer id);

    List<Temperature> findAll();

    List<Temperature> findBetweenTimes(LocalDateTime before, LocalDateTime to);

    int insert(Temperature temperature);

    int deleteById(Integer id);

    int update(Temperature temperature);
}
