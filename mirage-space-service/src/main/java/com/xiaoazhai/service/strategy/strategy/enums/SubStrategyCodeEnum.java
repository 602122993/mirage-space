package com.xiaoazhai.service.strategy.strategy.enums;

import com.xiaoazhai.service.strategy.strategy.StrategySchema;
import com.xiaoazhai.service.strategy.strategy.dto.WhiteListUserStrategySchema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubStrategyCodeEnum {

    USER_WHITE_LIST("userWhiteList", "白名单用户", WhiteListUserStrategySchema.class, 0, StrategyCodeEnum.ACCESS_STRATEGY);


    /**
     * 策略 code
     */
    private final String code;
    /**
     * 策略描述
     */
    private final String desc;
    /**
     * 策略协议（数据结构）
     */
    private final Class<? extends StrategySchema> strategySchema;
    /**
     * 优先级
     */
    private final Integer priority;
    /**
     * 父策略
     */
    private final StrategyCodeEnum parentStrategy;

    public static SubStrategyCodeEnum from(String strategyCode) {
        for (SubStrategyCodeEnum subStrategyCodeEnum : SubStrategyCodeEnum.values()) {
            if (subStrategyCodeEnum.getCode().equals(strategyCode)) {
                return subStrategyCodeEnum;
            }
        }
        return null;
    }
}
