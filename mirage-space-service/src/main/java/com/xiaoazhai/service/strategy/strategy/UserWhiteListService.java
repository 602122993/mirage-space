package com.xiaoazhai.service.strategy.strategy;

import com.xiaoazhai.common.strategy.FieldWrapper;
import com.xiaoazhai.service.strategy.strategy.dto.WhiteListUserStrategySchema;
import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;
import com.xiaoazhai.service.strategy.strategy.expression.StrategyContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserWhiteListService implements BaseStrategyService<WhiteListUserStrategySchema> {


    @Override
    public boolean isPass(WhiteListUserStrategySchema strategySchema, StrategyContext strategyContext) {
        FieldWrapper<List<Long>> strategy = strategySchema.getWhiteList();
        wrapperLong(strategy);
        return strategy.verify(strategyContext.getProcessContext().getUserId());
    }

    @Override
    public String getStrategyCode() {
        return SubStrategyCodeEnum.USER_WHITE_LIST.getCode();
    }


    public void wrapperLong(FieldWrapper<List<Long>> strategy) {
        List<Long> value = new ArrayList<>();
        for (Object item : strategy.getValue()) {
            value.add(Long.valueOf(String.valueOf(item)));
        }
        strategy.setValue(value);
    }
}
