package com.xiaoazhai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通道类型枚举
 */
@AllArgsConstructor
@Getter
public enum ChannelTypeEnum {

    CONFIG_DATA(1, "配置数据"),
    ;

    private final int code;

    private final String msg;

}
