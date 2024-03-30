package com.xiaoazhai.service.strategy.strategy;

import com.xiaoazhai.service.strategy.strategy.dto.WhiteListUserStrategySchema;
import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;
import com.xiaoazhai.service.strategy.strategy.expression.StrategyContext;
import org.springframework.stereotype.Component;

@Component
public class UserWhiteListService implements BaseStrategyService<WhiteListUserStrategySchema> {


    @Override
    public boolean isPass(WhiteListUserStrategySchema strategySchema, StrategyContext strategyContext) {
        return strategySchema.getWhiteList().verify(strategyContext.getProcessContext().getUserId());
    }

    @Override
    public String getStrategyCode() {
        return SubStrategyCodeEnum.USER_WHITE_LIST.getCode();
    }
}
