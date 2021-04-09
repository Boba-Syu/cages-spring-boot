package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.entity.TimingTaskType;
import cn.bobasyu.cagesspringboot.service.TimingTaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bobasyu
 */
@RestController
@RequestMapping("/api")
public class TimingTaskTypeController {
    private final TimingTaskTypeService timingTaskTypeService;

    @Autowired
    public TimingTaskTypeController(TimingTaskTypeService timingTaskTypeService) {
        this.timingTaskTypeService = timingTaskTypeService;
    }

    @GetMapping("/timing_task_type")
    public List<TimingTaskType> findALl() {
        return timingTaskTypeService.findALl();
    }

    @GetMapping("/timing_task_type/{id}")
    public TimingTaskType findById(@PathVariable Integer id) {
        return timingTaskTypeService.findById(id);
    }

    @PostMapping("/timing_task_type")
    public int insert(TimingTaskType timingTaskType) {
        return timingTaskTypeService.insert(timingTaskType);
    }

    @PutMapping("/timing_task_type")
    public int update(TimingTaskType timingTaskType) {
        return timingTaskTypeService.update(timingTaskType);
    }

    @DeleteMapping("/timing_task_type")
    public int delete(Integer id) {
        return timingTaskTypeService.deleteById(id);
    }
}
