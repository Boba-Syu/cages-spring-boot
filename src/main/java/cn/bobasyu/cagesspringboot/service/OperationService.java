package cn.bobasyu.cagesspringboot.service;

import cn.bobasyu.cagesspringboot.entity.Operation;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
public interface OperationService {

    Operation findById(Integer id);

    List<Operation> findBetweenTimes(LocalDateTime from, LocalDateTime to);

    List<Operation> findAll();

    int insert(Operation operation);

    int deleteById(Integer id);

    int updateById(Operation operation);

}
