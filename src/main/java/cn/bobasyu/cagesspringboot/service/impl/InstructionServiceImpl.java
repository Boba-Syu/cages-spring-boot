package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.config.InstructionEnum;
import cn.bobasyu.cagesspringboot.netty.TCPLinkServerHandler;
import cn.bobasyu.cagesspringboot.service.InstructionService;
import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class InstructionServiceImpl implements InstructionService {
    Logger logger = LogManager.getLogger(InstructionServiceImpl.class);

    @Override
    public int sendInstruction(String msg) {
        InstructionEnum instruction = InstructionEnum.valueOf(msg);
        try {
            TCPLinkServerHandler.getChannelList().forEach(channel ->
                    channel.writeAndFlush(Unpooled.copiedBuffer(
                            String.valueOf(instruction.getNumber()), StandardCharsets.UTF_8)));
            logger.info("给下位机发送指令: " + instruction.getInstructionName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
