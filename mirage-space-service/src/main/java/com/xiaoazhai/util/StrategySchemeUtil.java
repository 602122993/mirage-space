package com.xiaoazhai.util;

import cn.hutool.core.util.ReflectUtil;
import com.xiaoazhai.common.strategy.FieldWrapper;
import com.xiaoazhai.dto.StrategyConfigDTO;
import com.xiaoazhai.service.strategy.strategy.StrategySchema;
import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;

import java.util.Map;

public class StrategySchemeUtil {

    public static StrategySchema parseStrategySchema(StrategyConfigDTO strategyConfigDTO, SubStrategyCodeEnum subStrategyCodeEnum) {
        StrategySchema result = ReflectUtil.newInstance(subStrategyCodeEnum.getStrategySchema());
        Map<String, Object> valueMap = strategyConfigDTO.getFields();
        strategyConfigDTO.getCondition().forEach(condition -> {
            Object value = valueMap.get(condition.getField());
            FieldWrapper fieldWrapper = new FieldWrapper(condition.getOp(), value);
            ReflectUtil.setFieldValue(result, condition.getField(), fieldWrapper);
        });
        return result;
    }

}
