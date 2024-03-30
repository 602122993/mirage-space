package com.xiaoazhai.service.strategy.channel.group;

import com.xiaoazhai.common.enums.ChannelGroupAssemblyEnum;
import com.xiaoazhai.dto.DispatcherChannelMatchDTO;
import com.xiaoazhai.dto.ProcessContext;

/**
 * 通道组组合策略
 * @see ChannelGroupAssemblyEnum
 */
public interface ChannelGroupAssemblyStrategy {

    /**
     * 获取通道组类型
     * @return 通道组类型
     */
    Integer getChannelGroupType();

    Object getChannelGroupData(DispatcherChannelMatchDTO dispatcherChannelMatch, ProcessContext processContext);
}
