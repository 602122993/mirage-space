package com.xiaoazhai.service.strategy.annotions;


import com.xiaoazhai.service.strategy.strategy.enums.OperatorEnum;
import com.xiaoazhai.service.strategy.strategy.enums.OptionEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyFieldComponentTypeEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyFieldValueTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyFieldDesc {

    /**
     * 名称
     */
    String name();

    /**
     * 前端控件类型
     */
    StrategyFieldComponentTypeEnum type();

    /**
     * 值类型
     */
    StrategyFieldValueTypeEnum valueType();

    /**
     * 选项
     */
    OptionEnum[] options() default {};


    /**
     * 操作类型
     */
    OperatorEnum[] operators() default {};
}