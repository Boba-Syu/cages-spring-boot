package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.entity.Temperature;
import cn.bobasyu.cagesspringboot.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
@RestController
@RequestMapping("/api")
public class TemperatureController {
    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/temperature/{id}")
    public Temperature findById(@PathVariable Integer id) {
        return temperatureService.findById(id);
    }

    @GetMapping("/temperature")
    public List<Temperature> findAll() {
        return temperatureService.findAll();
    }

    @GetMapping("/temperature/{from}/{to}")
    public List<Temperature> findBetweenTimes(@PathVariable LocalDateTime from, @PathVariable LocalDateTime to) {
        return temperatureService.findBetweenTimes(from, to);
    }

    @PostMapping("/temperature")
    public int insert(Temperature temperature) {
        return temperatureService.insert(temperature);
    }

    @PutMapping("/temperature")
    public int update(Temperature temperature) {
        return temperatureService.update(temperature);
    }

    @DeleteMapping("temperature")
    public int delete(Integer id) {
        return temperatureService.deleteById(id);
    }
}
