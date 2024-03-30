package com.xiaoazhai.dto;

import com.xiaoazhai.service.strategy.strategy.StrategySchema;
import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;
import lombok.Data;

import java.util.List;

/**
 * 调度器DTO
 */
@Data
public class SubStrategyDTO {

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
     *
     * @see StrategyConfigDTO
     */
    private String strategyDetail;
    /**
     * 策略协议
     */
    private StrategySchema strategySchema;

    /**
     * 策略code
     */
    private String strategyCode;
    /**
     * 策略code枚举
     */
    private SubStrategyCodeEnum subStrategyCodeEnum;

    /**
     * 策略白名单
     */
    private List<Long> whiteList;

}
