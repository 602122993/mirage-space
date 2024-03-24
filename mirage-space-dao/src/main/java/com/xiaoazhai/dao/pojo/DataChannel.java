package com.xiaoazhai.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 数据通道表，用于记录不同的数据通道信息
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Getter
@Setter
public class DataChannel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 通道名称
     */
    private String channelName;

    /**
     * 通道类型
     */
    private String channelType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
