package com.xiaoazhai.service.strategy.strategy.expression;

import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.dto.SubStrategyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 策略上下文
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyContext {

    /**
     * 流程上下文
     */
    private ProcessContext processContext;
    /**
     * 策略信息
     */
    private StrategyDTO strategyDTO;
    /**
     * 子策略信息
     */
    private SubStrategyDTO subStrategyDTO;

}
