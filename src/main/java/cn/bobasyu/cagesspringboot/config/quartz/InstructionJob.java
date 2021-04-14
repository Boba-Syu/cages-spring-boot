package cn.bobasyu.cagesspringboot.config.quartz;

import cn.bobasyu.cagesspringboot.config.InstructionEnum;
import cn.bobasyu.cagesspringboot.netty.TCPLinkServerHandler;
import io.netty.buffer.Unpooled;
import lombok.AllArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.nio.charset.StandardCharsets;

/**
 * @author bobasyu
 */
@AllArgsConstructor
public class InstructionJob implements Job {
    private final InstructionEnum task;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TCPLinkServerHandler.getChannelList().forEach(channel ->
                channel.writeAndFlush(Unpooled.copiedBuffer(
                        String.valueOf(task.getNumber()), StandardCharsets.UTF_8)));
    }

    static class HeatUpJob extends InstructionJob {
        public HeatUpJob() {
            super(InstructionEnum.HEAT_UP);
        }
    }

    static class HeatDownJob extends InstructionJob {
        public HeatDownJob() {
            super(InstructionEnum.HEAT_DOWN);
        }
    }

    static class FeedJob extends InstructionJob {
        public FeedJob() {
            super(InstructionEnum.FEED);
        }
    }

    static class OpenCameraJob extends InstructionJob {
        public OpenCameraJob() {
            super(InstructionEnum.OPEN_MOTION);
        }
    }

    static class CloseCameraJob extends InstructionJob {
        public CloseCameraJob() {
            super(InstructionEnum.CLOSE_MOTION);
        }
    }

}
