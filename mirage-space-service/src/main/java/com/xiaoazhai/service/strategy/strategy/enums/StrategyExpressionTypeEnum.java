package com.xiaoazhai.service.strategy.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrategyExpressionTypeEnum {


    AND("AND"),

    OR("OR"),

    EXPRESSION("EXPRESSION"),

    ;

    private String code;

    public static StrategyExpressionTypeEnum from(String strategyExpressionType) {
        for (StrategyExpressionTypeEnum strategyExpressionTypeEnum : StrategyExpressionTypeEnum.values()) {
            if (strategyExpressionTypeEnum.getCode().equals(strategyExpressionType)) {
                return strategyExpressionTypeEnum;
            }
        }
        return null;

    }

    public static String fromExpression(String expression) {
        if (AND.code.equals(expression)) {
            return AND.getCode();
        }
        if (OR.code.equals(expression)) {
            return OR.getCode();
        }
        return EXPRESSION.getCode();
    }
}
