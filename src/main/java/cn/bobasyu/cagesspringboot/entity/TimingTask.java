package cn.bobasyu.cagesspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 定时任务信息
 *
 * @author bobasyu
 */
@Data
public class TimingTask {
    @TableId(type= IdType.AUTO)
    private String id;
    /**
     * 定时任务种类
     */
    private Integer timingTaskType;
    /**
     * 操作种类
     */
    private Integer operationType;
    /**
     * 定时任务详情信息
     */
    private String msg;
    /**
     * 定时任务种类
     */
    private LocalDateTime createTime;
}
