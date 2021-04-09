package cn.bobasyu.cagesspringboot;

import cn.bobasyu.cagesspringboot.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CagesSpringBootApplicationTests {
    @Autowired
    OperationMapper operationMapper;
    @Autowired
    OperationTypeMapper operationTypeMapper;
    @Autowired
    TemperatureMapper temperatureMapper;
    @Autowired
    TimingTaskTypeMapper timingTaskTypeMapper;
    @Autowired
    TimingTaskMapper timingTaskMapper;

    @Test
    void contextLoads() {
        operationTypeMapper.selectList(null).forEach(System.out::println);
    }

}
