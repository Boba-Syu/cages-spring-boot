package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.entity.Operation;
import cn.bobasyu.cagesspringboot.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class OperationController {
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/operation")
    public List<Operation> findAll() {
        return operationService.findAll();
    }

    @GetMapping("/operation/{id}")
    public Operation findById(@PathVariable("id") Integer id) {
        return operationService.findById(id);
    }

    @GetMapping("/operation/{from}/{to}")
    public List<Operation> findBetweenTime(@PathVariable LocalDateTime from, @PathVariable LocalDateTime to) {
        return operationService.findBetweenTimes(from, to);
    }

    @PostMapping("/operation")
    public int insert(Operation operation) {
        return operationService.insert(operation);
    }

    @DeleteMapping("/operation/{id}")
    public int delete(@PathVariable Integer id) {
        return operationService.deleteById(id);
    }

    @PutMapping("/operation")
    public int update(Operation operation) {
        return operationService.updateById(operation);
    }
}
