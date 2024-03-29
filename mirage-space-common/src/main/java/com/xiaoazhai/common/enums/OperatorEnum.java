package com.xiaoazhai.common.enums;

import com.xiaoazhai.common.consts.OperatorConsts;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@Getter
public enum OperatorEnum {

    /**
     * 大于
     */
    GT("gt", "大于", OperatorConsts.TYPE_SINGLE_INPUT),

    /**
     * 小于
     */
    LT("lt", "小于", OperatorConsts.TYPE_SINGLE_INPUT),

    /**
     * 等于
     */
    EQ("eq", "等于", OperatorConsts.TYPE_SINGLE_INPUT),

    /**
     * 大于等于
     */
    GE("ge", "大于等于", OperatorConsts.TYPE_SINGLE_INPUT),

    /**
     * 小于等于
     */
    LE("le", "小于等于", OperatorConsts.TYPE_SINGLE_INPUT),

    /**
     * 不等于
     */
    NE("ne", "不等于", OperatorConsts.TYPE_SINGLE_INPUT),

    /**
     * 在范围内
     */
    RANGE("range", "范围", OperatorConsts.TYPE_TWO_INPUT),

    /**
     * 包含
     */
    CONTAIN("contain", "包含", OperatorConsts.TYPE_MULTIPLE_INPUT),

    /**
     * 模糊包含
     */
    FUZZY_CONTAIN("fuzzyContain", "模糊包含", OperatorConsts.TYPE_MULTIPLE_INPUT),

    /**
     * 模糊不包含
     */
    NOT_FUZZY_CONTAIN("notFuzzyContain", "模糊不包含", OperatorConsts.TYPE_MULTIPLE_INPUT),

    /**
     * 不包含
     */
    NOTCONTAIN("notcontain", "不包含", OperatorConsts.TYPE_MULTIPLE_INPUT),

    /**
     * 存在于
     */
    EXIST("exist", "存在于", OperatorConsts.TYPE_MULTIPLE_INPUT),

    /**
     * 表达式
     */
    EXPRESS("express", "表达式", OperatorConsts.TYPE_MULTIPLE_INPUT),

    ;

    private String key;
    private String value;
    private String type;

    public static OperatorEnum from(String code) {
        return Arrays.stream(values()).filter(x -> Objects.equals(code, x.getKey())).findAny().orElse(null);
    }
}
