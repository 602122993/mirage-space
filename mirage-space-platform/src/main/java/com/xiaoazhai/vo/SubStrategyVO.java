package com.xiaoazhai.vo;

import com.xiaoazhai.common.consts.OperatorConsts;
import com.xiaoazhai.dto.StrategyConfigDTO;
import com.xiaoazhai.dto.StrategyParamDTO;
import com.xiaoazhai.dto.SubStrategyDTO;
import com.xiaoazhai.service.strategy.strategy.enums.OperatorEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class SubStrategyVO {

    private Long id;
    /**
     * 策略 code
     */
    private String code;

    /**
     * 排序
     */
    private Integer index;
    /**
     * 白名单
     */
    private List<Long> whiteUserIdList;
    /**
     * 参数列表
     */
    private List<StrategyParamDTO> paramList;

    public SubStrategyDTO convertToDTO() {
        SubStrategyDTO subStrategyDTO = new SubStrategyDTO();
        subStrategyDTO.setId(id);
        subStrategyDTO.setStrategyCode(code);
        subStrategyDTO.setSort(index);
        subStrategyDTO.setWhiteList(whiteUserIdList);
        StrategyConfigDTO strategyConfigDTO = new StrategyConfigDTO();
        strategyConfigDTO.setCondition(paramList);
        Map<String, Object> field = new HashMap<>();
        paramList.forEach(param -> {
            if (Objects.equals(OperatorEnum.from(param.getOp()).getType(), OperatorConsts.TYPE_SINGLE_INPUT)) {
                field.put(param.getField(), param.getValues().getFirst());
            } else {
                field.put(param.getField(), param.getValues());
            }
        });
        strategyConfigDTO.setFields(field);
        subStrategyDTO.setStrategyConfig(strategyConfigDTO);
        return subStrategyDTO;

    }
}
