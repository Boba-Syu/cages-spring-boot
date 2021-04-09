package cn.bobasyu.cagesspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 定时任务的种类信息
 *
 * @author bobasyu
 */
@Data
public class TimingTaskType {
    @TableId(type= IdType.AUTO)
    private Integer id;
    /**
     * 定时任务类型信息
     */
    private String timingTaskType;
    private LocalDateTime createTime;
}
