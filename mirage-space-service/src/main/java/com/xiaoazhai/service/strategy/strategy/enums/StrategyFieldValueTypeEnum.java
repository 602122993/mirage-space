package com.xiaoazhai.service.strategy.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrategyFieldValueTypeEnum {

    STRING(String.class),LONG(Long.class)

    ;
    public Class<?> clazz;
}
