package cn.bobasyu.cagesspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 具体操作指令执行的日志信息
 *
 * @author bobasyu
 */
@Data
public class Operation {
    @TableId(type=IdType.AUTO)
    private String Id;
    /**
     * 操作种类信息
     */
    private Integer operationType;
    private LocalDateTime createTime;
}
