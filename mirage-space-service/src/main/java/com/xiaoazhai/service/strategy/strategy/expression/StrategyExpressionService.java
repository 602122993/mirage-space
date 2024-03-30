package com.xiaoazhai.service.strategy.strategy.expression;

import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.dto.SubStrategyDTO;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum;

import java.util.List;

public interface StrategyExpressionService {

    StrategyExpressionTypeEnum getCode();

    boolean isPass(StrategyContext strategyContext);
}
