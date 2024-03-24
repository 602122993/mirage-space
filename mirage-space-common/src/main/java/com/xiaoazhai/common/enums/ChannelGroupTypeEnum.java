package com.xiaoazhai.common.enums;

import lombok.Getter;

/**
 * 通道组组合数据方式
 */
@Getter
public enum ChannelGroupTypeEnum {

    /**
     * 非通道组
     */
    NO_GROUP(0),
    /**
     * 通道数据获取方式
     */
    CHANNEL(2);

    private final int code;

    ChannelGroupTypeEnum(Integer code) {
        this.code = code;
    }

}
