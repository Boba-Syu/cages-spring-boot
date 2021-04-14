package cn.bobasyu.cagesspringboot;

import cn.bobasyu.cagesspringboot.netty.TCPLinkServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bobasyu.cagesspringboot.mapper")
public class CagesSpringBootApplication implements CommandLineRunner {
    private final static Logger logger = LogManager.getLogger(CagesSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CagesSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        int port = 6666;
        try {
            TCPLinkServer.start(port);
            logger.info("端口" + port + "启动成功");
        } catch (Exception e) {
            logger.info("端口" + port + "启动失败");
            e.printStackTrace();
        }
    }
}
