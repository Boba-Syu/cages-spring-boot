package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.entity.Operation;
import cn.bobasyu.cagesspringboot.mapper.OperationMapper;
import cn.bobasyu.cagesspringboot.service.OperationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasyu
 */
@Service
public class OperationServiceImpl implements OperationService {
    private final OperationMapper operationMapper;

    @Autowired
    public OperationServiceImpl(OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }

    @Override
    public Operation findById(Integer id) {
        return operationMapper.selectById(id);
    }

    @Override
    public List<Operation> findBetweenTimes(LocalDateTime from, LocalDateTime to) {
        QueryWrapper<Operation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "operation_type", "create_time")
                .between("create_time", from, to);
        return operationMapper.selectList(queryWrapper);
    }

    @Override
    public List<Operation> findAll() {
        return operationMapper.selectList(null);

    }

    @Override
    public int insert(Operation operation) {
        return operationMapper.insert(operation);
    }

    @Override
    public int deleteById(Integer id) {
        return operationMapper.deleteById(id);
    }

    @Override
    public int updateById(Operation operation) {
        return operationMapper.updateById(operation);
    }

}
