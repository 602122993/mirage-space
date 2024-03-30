package com.xiaoazhai.service.strategy.strategy.dto;

import com.xiaoazhai.service.strategy.annotions.StrategyFieldDesc;
import com.xiaoazhai.service.strategy.strategy.enums.OperatorEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyFieldComponentTypeEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyFieldValueTypeEnum;
import com.xiaoazhai.common.strategy.FieldWrapper;
import com.xiaoazhai.service.strategy.strategy.StrategySchema;

public class WhiteListUserStrategy extends StrategySchema {


    @StrategyFieldDesc(name = "白名单用户",
            type = StrategyFieldComponentTypeEnum.INPUT,
            valueType = StrategyFieldValueTypeEnum.STRING,
            operators = {OperatorEnum.CONTAIN, OperatorEnum.NO_CONTAIN}
    )
    private FieldWrapper<Long> whiteList;
}
