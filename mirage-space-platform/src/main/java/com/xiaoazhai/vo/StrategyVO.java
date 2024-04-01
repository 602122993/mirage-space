package com.xiaoazhai.vo;

import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class StrategyVO {

    private Long id;
    /**
     * 策略 code
     */
    private String code;
    /**
     * 策略表达式
     */
    private String expression;
    /**
     * 子策略信息
     */
    private List<SubStrategyVO> subStrategyVOList;
    /**
     * 白名单
     */
    private List<Long> whiteUserIdList;


    public StrategyDTO convertToDTO(Long bindId, String bindType) {
        StrategyDTO strategyDTO = new StrategyDTO();
        strategyDTO.setId(id);
        strategyDTO.setStrategyCode(code);
        strategyDTO.setStrategyExpression(expression);
        strategyDTO.setStrategyExpressionType(StrategyExpressionTypeEnum.fromExpression(expression));
        strategyDTO.setWhiteList(whiteUserIdList);
        strategyDTO.setBindId(bindId);
        strategyDTO.setBindType(bindType);
        strategyDTO.setSubStrategyList(subStrategyVOList.stream().map(SubStrategyVO::convertToDTO).toList());
        return strategyDTO;
    }
}