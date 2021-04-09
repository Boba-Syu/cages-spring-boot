package cn.bobasyu.cagesspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 温度信息
 *
 * @author bobasyu
 */
@Data
public class Temperature {
    @TableId(type= IdType.AUTO)
    private String Id;
    /**
     * 温度的值
     */
    private Double temperature;
    private LocalDateTime createTime;
}
