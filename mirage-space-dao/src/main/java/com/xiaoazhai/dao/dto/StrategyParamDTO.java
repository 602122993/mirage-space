package com.xiaoazhai.dao.dto;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaoazhai.common.enums.OperatorEnum;
import lombok.Data;

import java.util.List;

@Data
public class StrategyParamDTO   {

    /**
     * 操作符 {@link OperatorEnum}
     */
    private String op;

    /**
     * 字段名
     */
    private String field;

    /**
     * 具体值的类型
     */
    private Class<?> valueType;

    /**
     * 具体值
     */
    private List<Object> values;

    public boolean valid() {
        if (CollectionUtils.isEmpty(values)) {
            throw new IllegalArgumentException("values不能为空!");
        }
        return true;
    }
}
