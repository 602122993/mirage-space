package com.xiaoazhai.mirage.space.test;


import com.alibaba.fastjson.JSON;
import com.xiaoazhai.dto.DispatcherDTO;
import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.dto.StrategyParamDTO;
import com.xiaoazhai.service.IStrategyService;
import com.xiaoazhai.service.impl.StrategyExecuteService;
import com.xiaoazhai.service.strategy.strategy.enums.*;
import com.xiaoazhai.vo.StrategyVO;
import com.xiaoazhai.vo.SubStrategyVO;
import jakarta.annotation.Resource;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyUnitTest {

    @Resource
    private IStrategyService strategyService;

    @Resource
    private StrategyExecuteService strategyExecuteService;

    @Test
    public void testAddStrategy() {
        StrategyVO request = buildAssessStrategyVO();
        StrategyDTO dto = request.convertToDTO(1012L, StrategyBindTypeEnum.DISPATCHER_CHANNEL.getCode());
        strategyService.addOrUpdate(Lists.newArrayList(dto));
    }
    @Test
    public void testExecuteStrategy(){
        List<StrategyDTO> strategy = strategyService.queryStrategy(StrategyBindTypeEnum.DISPATCHER_CHANNEL.getCode(), 1012L);
        ProcessContext context = new ProcessContext();
        context.setUserId(1L);
        DispatcherDTO dispatcherDTO = new DispatcherDTO();
        dispatcherDTO.setStrategyList(strategy);
        boolean result = strategyExecuteService.isPassStrategy(dispatcherDTO, context);
        assert !result;
    }

    private StrategyVO buildAssessStrategyVO() {
        StrategyVO strategyVO = new StrategyVO();
        strategyVO.setCode(StrategyCodeEnum.ACCESS_STRATEGY.getCode());
        strategyVO.setExpression(StrategyExpressionTypeEnum.AND.getCode());
        strategyVO.setSubStrategyVOList(Lists.newArrayList(buildWhiteListStrategy()));
        return strategyVO;
    }

    private SubStrategyVO buildWhiteListStrategy() {
        SubStrategyVO subStrategyVO = new SubStrategyVO();
        subStrategyVO.setCode(SubStrategyCodeEnum.USER_WHITE_LIST.getCode());
        subStrategyVO.setIndex(0);
        subStrategyVO.setParamList(buildWhiteListParamList());
        return subStrategyVO;
    }

    private List<StrategyParamDTO> buildWhiteListParamList() {
        StrategyParamDTO strategyParamDTO = new StrategyParamDTO();
        strategyParamDTO.setOp(OperatorEnum.CONTAIN.getKey());
        strategyParamDTO.setField("whiteList");
        strategyParamDTO.setValues(Lists.newArrayList(1L, 2L));
        return Lists.newArrayList(strategyParamDTO);
    }
}
