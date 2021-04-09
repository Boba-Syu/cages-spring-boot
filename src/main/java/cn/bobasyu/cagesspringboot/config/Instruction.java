package cn.bobasyu.cagesspringboot.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 对下位机发送的指令
 *
 * @author bobasyu
 */
@AllArgsConstructor
@Getter
public enum Instruction {
    HEAT_UP("加温", 0),
    HEAT_DOWN("加温", 1),
    FEED("喂食", 2),
    OPEN_MOTION("打开摄像头", 4),
    CLOSE_MOTION("关闭摄像头", 5);

    private final String InstructionName;
    private final int number;
}
