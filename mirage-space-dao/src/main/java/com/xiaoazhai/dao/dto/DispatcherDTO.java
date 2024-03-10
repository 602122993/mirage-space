package com.xiaoazhai.dao.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class DispatcherDTO implements Serializable {


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

}
