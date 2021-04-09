package cn.bobasyu.cagesspringboot.service;

import cn.bobasyu.cagesspringboot.entity.OperationType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
public interface OperationTypeService {
    OperationType findById(Integer id);

    List<OperationType> findBetweenTimes(LocalDateTime from, LocalDateTime to);

    List<OperationType> findAll();

    int insert(OperationType operationType);

    int deleteById(Integer id);

    int updateById(OperationType operationType);
}
