package com.xiaoazhai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通道组组合数据方式
 */

@Getter
@AllArgsConstructor
public enum ChannelGroupAssemblyEnum {

    /**
     * 优先级
     */
    PRIORITY(1),;
    private  int code;


    public static ChannelGroupAssemblyEnum getEnumByCode(Integer channelGroupAssemblyEnum) {
        for (ChannelGroupAssemblyEnum value : ChannelGroupAssemblyEnum.values()) {
            if (value.getCode() == channelGroupAssemblyEnum) {
                return value;
            }
        }
        return null;
    }
}
