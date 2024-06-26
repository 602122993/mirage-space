package com.xiaoazhai.service.strategy.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrategyCodeEnum {

    ACCESS_STRATEGY("accessStrategy", "访问策略"),
    ;

    private String code;

    private String msg;
}
