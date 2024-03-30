package com.xiaoazhai.service.strategy.annotions;

import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyDesc {
    SubStrategyCodeEnum value();
}
