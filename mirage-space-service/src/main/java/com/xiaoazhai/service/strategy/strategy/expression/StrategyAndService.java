package com.xiaoazhai.service.strategy.strategy.expression;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.dto.SubStrategyDTO;
import com.xiaoazhai.service.impl.StrategyExecuteService;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StrategyAndService implements StrategyExpressionService {

    @Resource
    private StrategyExecuteService strategyExecuteService;

    @Override
    public StrategyExpressionTypeEnum getCode() {
        return StrategyExpressionTypeEnum.AND;
    }

    @Override
    public boolean isPass(StrategyContext strategyContext) {
        Long userId = strategyContext.getProcessContext().getUserId();
        StrategyDTO strategyDTO = strategyContext.getStrategyDTO();
        if (CollectionUtils.isNotEmpty(strategyDTO.getWhiteList()) && strategyDTO.getWhiteList().contains(userId)) {
            //白名单默认通过
            return true;
        }
        List<SubStrategyDTO> subStrategyList = strategyDTO.getSubStrategyList();
        for (SubStrategyDTO subStrategyDTO : subStrategyList) {
            strategyContext.setSubStrategyDTO(subStrategyDTO);
            if (!strategyExecuteService.isPassSubStrategy(strategyContext)) {
                return false;
            }
        }
        return true;
    }

}
