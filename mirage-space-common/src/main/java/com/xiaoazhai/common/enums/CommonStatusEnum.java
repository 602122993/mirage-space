package com.xiaoazhai.common.enums;

import lombok.Getter;

/**
 * 通用状态枚举 0，删除 1，正常
 */
@Getter
public enum CommonStatusEnum {
    /**
     * 删除
     */
    DELETE(0, "删除"),
    /**
     * 正常
     */
    NORMAL(1, "正常");

    private Integer status;

    private String desc;

    CommonStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

}
