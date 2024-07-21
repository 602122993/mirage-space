package com.xiaoazhai.dto;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaoazhai.service.strategy.strategy.enums.OperatorEnum;
import lombok.Data;

import java.util.List;

@Data
public class StrategyParamDTO {

    /**
     * 操作符
     *
     * @see OperatorEnum
     */
    private String op;

    /**
     * 字段名
     */
    private String field;

    /**
     * 具体值
     */
    private List<Object> values;
    /**
     * 值类型
     */
    private Class<?> type;

    public boolean valid() {
        if (CollectionUtils.isEmpty(values)) {
            throw new IllegalArgumentException("values不能为空!");
        }
        return true;
    }
}
