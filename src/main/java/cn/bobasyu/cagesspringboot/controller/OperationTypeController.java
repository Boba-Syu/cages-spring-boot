package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.entity.OperationType;
import cn.bobasyu.cagesspringboot.service.OperationTypeService;
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
public class OperationTypeController {
    private final OperationTypeService operationTypeService;

    @Autowired
    public OperationTypeController(OperationTypeService operationTypeService) {
        this.operationTypeService = operationTypeService;
    }

    @GetMapping("/operation_type")
    public List<OperationType> findAll() {
        return operationTypeService.findAll();
    }

    @GetMapping("/operation_type/{id}")
    public OperationType findById(@PathVariable Integer id) {
        return operationTypeService.findById(id);
    }

    @GetMapping("/operation_type/{from}/{to}")
    public List<OperationType> findBetweenTimes(@PathVariable LocalDateTime from, @PathVariable LocalDateTime to) {
        return operationTypeService.findBetweenTimes(from, to);
    }

    @PostMapping("/operation_type")
    public int insert(OperationType operationType) {
        return operationTypeService.insert(operationType);
    }

    @DeleteMapping("/operation_type")
    public int delete(Integer id) {
        return operationTypeService.deleteById(id);
    }

    @PutMapping("/operation_type")
    public int update(OperationType operationType) {
        return operationTypeService.updateById(operationType);
    }
}
