package com.xiaoazhai.service.strategy.strategy.dto;

import com.xiaoazhai.service.strategy.annotions.StrategyFieldDesc;
import com.xiaoazhai.service.strategy.strategy.enums.OperatorEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyFieldComponentTypeEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyFieldValueTypeEnum;
import com.xiaoazhai.common.strategy.FieldWrapper;
import com.xiaoazhai.service.strategy.strategy.StrategySchema;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class WhiteListUserStrategySchema extends StrategySchema {


    @StrategyFieldDesc(name = "白名单用户",
            type = StrategyFieldComponentTypeEnum.INPUT,
            valueType = StrategyFieldValueTypeEnum.LONG,
            operators = {OperatorEnum.CONTAIN, OperatorEnum.NO_CONTAIN}
    )
    private FieldWrapper<List<Long>> whiteList;
}
