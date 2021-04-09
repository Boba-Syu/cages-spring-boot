package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.entity.OperationType;
import cn.bobasyu.cagesspringboot.entity.TimingTask;
import cn.bobasyu.cagesspringboot.entity.TimingTaskType;
import cn.bobasyu.cagesspringboot.service.TimingTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bobasyu
 */
@RestController
@RequestMapping("/api")
public class TimingTaskController {
    private final TimingTaskService timingTaskService;

    @Autowired
    public TimingTaskController(TimingTaskService timingTaskService) {
        this.timingTaskService = timingTaskService;
    }

    @GetMapping("/timing_task/id={id}")
    public TimingTask findById(@PathVariable Integer id) {
        return timingTaskService.findById(id);
    }

    @GetMapping("/timing_task")
    public List<TimingTask> findALl() {
        return timingTaskService.findAll();
    }

    @GetMapping("/timing_task/timing_task_type={timing_task_type}")
    public List<TimingTask> findByTimingTaskType(@PathVariable("timing_task_type") TimingTaskType timingTasktype) {
        return timingTaskService.findByTimingTaskType(timingTasktype);
    }

    @GetMapping("/timing_task/operation_type={operation_type}")
    public List<TimingTask> findByOperationType(@PathVariable("operation_type") OperationType operationType) {
        return timingTaskService.fndBtOperationType(operationType);
    }

    @PostMapping("/timing_task")
    public int insert(TimingTask timingTask) {
        return timingTaskService.insert(timingTask);
    }

    @PutMapping("/timing_task")
    public int update(TimingTask timingTask) {
        return timingTaskService.update(timingTask);
    }

    @DeleteMapping("timing_task")
    public int delete(Integer id) {
        return timingTaskService.deleteById(id);
    }
}
