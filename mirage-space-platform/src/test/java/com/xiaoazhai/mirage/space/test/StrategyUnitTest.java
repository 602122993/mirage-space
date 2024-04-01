package com.xiaoazhai.mirage.space.test;


import com.alibaba.fastjson2.JSON;
import com.xiaoazhai.dto.StrategyConfigDTO;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.dto.StrategyParamDTO;
import com.xiaoazhai.dto.SubStrategyDTO;
import com.xiaoazhai.service.IStrategyService;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyBindTypeEnum;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyExpressionTypeEnum;
import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;
import jakarta.annotation.Resource;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyUnitTest {

    @Resource
    private IStrategyService strategyService;
    

    @Test
    public void testAddStrategy() {
        StrategyDTO strategyDTO = new StrategyDTO();
        strategyDTO.setStrategyCode("accessStrategy");
        strategyDTO.setBindId(1234L);
        strategyDTO.setBindType(StrategyBindTypeEnum.DISPATCHER.getCode());
        strategyDTO.setStrategyExpressionType(StrategyExpressionTypeEnum.AND.getCode());
        strategyDTO.setWhiteList(Lists.newArrayList(1L, 2L, 3L));
        SubStrategyDTO subStrategyDTO = new SubStrategyDTO();
        subStrategyDTO.setStrategyCode(SubStrategyCodeEnum.USER_WHITE_LIST.getCode());
        subStrategyDTO.setWhiteList(Lists.newArrayList(1L, 2L, 3L));
        StrategyConfigDTO strategyConfigDTO = new StrategyConfigDTO();
        StrategyParamDTO strategyParamDTO = new StrategyParamDTO();
        strategyParamDTO.setOp("contains");
        strategyParamDTO.setValues(Lists.newArrayList("1", "2", "3"));
        strategyParamDTO.setField("whiteList");
        Map<String, Object> fields = new HashMap<>();
        fields.put("whiteList", Lists.newArrayList(1L, 2L, 3L));
        strategyConfigDTO.setFields(fields);
        strategyConfigDTO.setCondition(Lists.newArrayList(strategyParamDTO));
        subStrategyDTO.setStrategyConfig(strategyConfigDTO);
        strategyDTO.setSubStrategyList(Lists.newArrayList(subStrategyDTO));
        strategyService.addOrUpdate(Lists.newArrayList(strategyDTO));
        System.out.println(JSON.toJSONString(strategyService.queryStrategy(StrategyBindTypeEnum.DISPATCHER.getCode(), 1234L)));
    }
}
