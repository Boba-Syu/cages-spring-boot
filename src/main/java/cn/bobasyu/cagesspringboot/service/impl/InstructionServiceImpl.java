package cn.bobasyu.cagesspringboot.service.impl;

import cn.bobasyu.cagesspringboot.config.Instruction;
import cn.bobasyu.cagesspringboot.netty.TCPLinkServerHandler;
import cn.bobasyu.cagesspringboot.service.InstructionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class InstructionServiceImpl implements InstructionService {
    Logger logger = LogManager.getLogger(InstructionServiceImpl.class);

    @Override
    public int sendInstruction(String msg) {
        Instruction instruction = Instruction.valueOf(msg);
        try {
            TCPLinkServerHandler.getChannelList().forEach(channel ->
                    channel.writeAndFlush(instruction.getNumber()));
            logger.info("给下位机发送指令: " + instruction.getInstructionName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
