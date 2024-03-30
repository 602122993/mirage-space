package com.xiaoazhai.service.strategy.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyDesc {
    StrategySubCodeEnum value();

    /**
     * 子策略组件类型
     */
    String type() default "";
    Class<?> delegate() default Class.class;
}
