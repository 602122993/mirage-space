package com.xiaoazhai.dto;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.xiaoazhai.common.annotations.JsonDetail;
import com.xiaoazhai.common.util.JsonDetailFormatUtil;
import com.xiaoazhai.dao.pojo.Strategy;
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
    private Long bindId;

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
    @JsonDetail
    private String strategyExpression;

    /**
     * 策略表达式类型
     *
     * @see com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum
     */
    @JsonDetail
    private String strategyExpressionType;
    /**
     * 策略表达式类型枚举
     */
    private StrategyExpressionTypeEnum strategyExpressionTypeEnum;

    /**
     * 策略白名单
     */
    @JsonDetail
    private List<Long> whiteList;

    /**
     * 子策略
     */
    private List<SubStrategyDTO> subStrategyList;


    public Strategy toStrategy() {
        Strategy strategy = new Strategy();
        strategy.setStrategyCode(strategyCode);
        strategy.setBindType(bindType);
        strategy.setBindId(bindId);
        strategy.setStrategyDetail(JsonDetailFormatUtil.formatJson(this));
        strategy.setId(id);
        return strategy;
    }

}
