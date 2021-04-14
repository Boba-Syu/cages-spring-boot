package cn.bobasyu.cagesspringboot;

import cn.bobasyu.cagesspringboot.config.InstructionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InstructionTest {
    @Test
    public void test() {
        System.out.println(InstructionEnum.valueOf("OPEN_MOTION"));
    }
}
