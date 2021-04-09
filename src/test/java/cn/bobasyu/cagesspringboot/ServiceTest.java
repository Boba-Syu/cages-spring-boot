package cn.bobasyu.cagesspringboot;

import cn.bobasyu.cagesspringboot.entity.Operation;
import cn.bobasyu.cagesspringboot.service.OperationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ServiceTest {
    @Autowired
    OperationService operationService;

    @Test
    void test() {
        Operation operation = new Operation();
        operation.setOperationType(1);
        operation.setCreateTime(LocalDateTime.now());
        operationService.deleteById(3);
    }

}
