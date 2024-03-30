package com.xiaoazhai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.xiaoazhai.service.strategy.annotions.HasStrategy;
import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.service.strategy.strategy.BaseStrategyService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class StrategyExecuteService {

    @Resource
    private List<BaseStrategyService> strategyServiceList;


    private Map<String, BaseStrategyService> strategyServiceMap;

    @PostConstruct
    public void init() {
        if (CollectionUtil.isNotEmpty(strategyServiceList)) {
            strategyServiceMap = strategyServiceList.stream().collect(Collectors.toMap(BaseStrategyService::getStrategyCode, Function.identity()));
        } else {
            strategyServiceMap = Collections.emptyMap();
        }
    }

    public boolean isPassStrategy(HasStrategy hasStrategy, ProcessContext processContext) {
        List<StrategyDTO> strategyList = hasStrategy.getStrategyList();
        if (CollectionUtil.isEmpty(strategyList)) {
            log.info("策略列表为空,默认视为通过");
            return true;
        }
        for (StrategyDTO strategyDTO : strategyList) {
            if (CollectionUtil.isNotEmpty(strategyDTO.getWhiteList()) && strategyDTO.getWhiteList().contains(processContext.getUserId())) {
                log.info("命中策略白名单");
                return true;
            }
        }

        return true;
    }

}
