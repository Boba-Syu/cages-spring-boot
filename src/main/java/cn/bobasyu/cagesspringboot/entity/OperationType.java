package cn.bobasyu.cagesspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作指令的种类信息
 *
 * @author bobasyu
 */
@Data
public class OperationType {
    @TableId(type= IdType.AUTO)
    private Integer id;
    /**
     * 操作类型信息
     */
    private String operationType;
    private LocalDateTime createTime;
}
