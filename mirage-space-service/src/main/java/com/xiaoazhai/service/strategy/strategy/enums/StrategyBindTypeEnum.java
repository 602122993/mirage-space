package com.xiaoazhai.service.strategy.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrategyBindTypeEnum {

    /**
     * \
     * 子策略绑定
     */
    STRATEGY("STRATEGY"),
    /**
     * 调度器
     */
    DISPATCHER("DISPATCHER"),
    /**
     * 调度器通道 match 绑定
     */
    DISPATCHER_CHANNEL("DISPATCHER_CHANNEL"),
    ;
    private String code;


}
