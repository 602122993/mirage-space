package com.xiaoazhai.dto;

import com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * 策略 dto
 */
@Data
public class StrategyDTO {

    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 绑定类型
     *
     * @see com.xiaoazhai.service.strategy.strategy.enums.StrategyBindTypeEnum
     */
    private String bindType;

    /**
     * 绑定ID
     * <p>
     * 具体绑定的业务id
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
     * 策略表达式
     */
    private String strategyExpression;

    /**
     * 策略表达式类型
     *
     * @see com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum
     */
    private String strategyExpressionType;
    /**
     * 策略表达式类型枚举
     */
    private StrategyExpressionTypeEnum strategyExpressionTypeEnum;

    /**
     * 策略白名单
     */
    private List<Long> whiteList;

    /**
     * 子策略
     */
    private List<SubStrategyDTO> subStrategyList;
}
