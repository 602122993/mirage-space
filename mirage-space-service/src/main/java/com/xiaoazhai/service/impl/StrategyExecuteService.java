package com.xiaoazhai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.xiaoazhai.dto.SubStrategyDTO;
import com.xiaoazhai.service.strategy.annotions.HasStrategy;
import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.service.strategy.strategy.BaseStrategyService;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum;
import com.xiaoazhai.service.strategy.strategy.expression.StrategyContext;
import com.xiaoazhai.service.strategy.strategy.expression.StrategyExpressionService;
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

    @Resource
    private List<StrategyExpressionService> strategyExpressionServiceList;

    @Resource

    private Map<String, BaseStrategyService> strategyServiceMap;


    private Map<StrategyExpressionTypeEnum, StrategyExpressionService> strategyExpressionServiceMap;

    @PostConstruct
    public void init() {
        if (CollectionUtil.isNotEmpty(strategyServiceList)) {
            strategyServiceMap = strategyServiceList.stream().collect(Collectors.toMap(BaseStrategyService::getStrategyCode, Function.identity()));
        } else {
            strategyServiceMap = Collections.emptyMap();
        }

        if (CollectionUtil.isNotEmpty(strategyExpressionServiceList)) {
            strategyExpressionServiceMap = strategyExpressionServiceList.stream().collect(Collectors.toMap(StrategyExpressionService::getCode, Function.identity()));
        } else {
            strategyExpressionServiceMap = Collections.emptyMap();
        }
    }

    public boolean isPassStrategy(HasStrategy hasStrategy, ProcessContext processContext) {
        List<StrategyDTO> strategyList = hasStrategy.getStrategyList();
        if (CollectionUtil.isEmpty(strategyList)) {
            log.info("策略列表为空,默认视为通过");
            return true;
        }
        for (StrategyDTO strategyDTO : strategyList) {
            StrategyContext strategyContext = StrategyContext.builder().processContext(processContext).strategyDTO(strategyDTO).build();
            boolean isPass = strategyExpressionServiceMap.get(strategyDTO.getStrategyExpressionTypeEnum()).isPass(strategyContext);
            if (!isPass) {
                return false;
            }
        }
        return true;
    }

    public boolean isPassSubStrategy(StrategyContext strategyContext) {
        SubStrategyDTO subStrategyDTO = strategyContext.getSubStrategyDTO();
        if (subStrategyDTO == null) {
            return false;
        }
        BaseStrategyService executor = strategyServiceMap.get(subStrategyDTO.getStrategyCode());
        if(executor==null){
            log.error("查询不到对应策略");
        }
        return executor.isPass(subStrategyDTO.getStrategySchema(), strategyContext);

    }
}
