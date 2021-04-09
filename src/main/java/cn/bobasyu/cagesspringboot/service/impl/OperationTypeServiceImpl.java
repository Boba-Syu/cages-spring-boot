package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.entity.OperationType;
import cn.bobasyu.cagesspringboot.mapper.OperationTypeMapper;
import cn.bobasyu.cagesspringboot.service.OperationTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bobasysu
 */
@Service
public class OperationTypeServiceImpl implements OperationTypeService {
    private final OperationTypeMapper operationTypeMapper;

    @Autowired
    public OperationTypeServiceImpl(OperationTypeMapper operationTypeMapper) {
        this.operationTypeMapper = operationTypeMapper;
    }

    @Override
    public OperationType findById(Integer id) {
        return operationTypeMapper.selectById(id);
    }

    @Override
    public List<OperationType> findBetweenTimes(LocalDateTime from, LocalDateTime to) {
        QueryWrapper<OperationType> wrapper = new QueryWrapper<>();
        wrapper.select("id", "create_time", "operatime_type")
                .between("create_time", from, to);
        return operationTypeMapper.selectList(wrapper);
    }

    @Override
    public List<OperationType> findAll() {
        return operationTypeMapper.selectList(null);
    }

    @Override
    public int insert(OperationType operationType) {
        return operationTypeMapper.insert(operationType);
    }

    @Override
    public int deleteById(Integer id) {
        return operationTypeMapper.deleteById(id);
    }

    @Override
    public int updateById(OperationType operationType) {
        return operationTypeMapper.updateById(operationType);
    }
}
