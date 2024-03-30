package com.xiaoazhai.service.strategy.strategy;

import com.xiaoazhai.service.strategy.strategy.expression.StrategyContext;

/**
 * 基础的策略服务
 */
public interface BaseStrategyService<T extends StrategySchema> {

    boolean isPass(T strategySchema, StrategyContext strategyContext);

    String getStrategyCode();


}
