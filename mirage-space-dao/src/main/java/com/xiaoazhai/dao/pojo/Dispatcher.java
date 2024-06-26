package com.xiaoazhai.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 流量分配表
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Getter
@Setter
public class Dispatcher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 位置编码
     */
    private String positionCode;

    /**
     * 调度器名称
     */
    private String dispatcherName;

    /**
     * 创建时间，自动生成
     */
    private LocalDateTime createTime;

    /**
     * 更新时间，自动更新
     */
    private LocalDateTime updateTime;
}
