package com.xiaoazhai.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StrategyConfigDTO {

    /**
     * 子策略条件
     */
    private List<StrategyParamDTO> condition;
    /**
     * key:字段名，value: 对应的值
     */
    private Map<String, Object> fields;

}
