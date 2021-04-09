package cn.bobasyu.cagesspringboot;

import cn.bobasyu.cagesspringboot.netty.TCPLinkServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class NettyTest {
    @Test
    public  void startPort(String[] args) {
        TCPLinkServer.start(8888);
    }
}
