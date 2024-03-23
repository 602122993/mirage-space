package com.xiaoazhai.dao.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * 调度器DTO
 */
@Data
public class StrategyDTO {

    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 绑定类型
     */
    private String bindType;

    /**
     * 绑定ID
     */
    private String bindId;

    /**
     * 策略详情
     */
    private String strategyDetail;

    /**
     * 策略code
     */
    private String strategyCode;

    /**
     * 策略白名单
     */
    private List<Long> whiteList;
}
