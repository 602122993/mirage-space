package com.xiaoazhai.service.strategy.channel;

import com.xiaoazhai.dto.DataChannelDTO;
import com.xiaoazhai.dto.ProcessContext;

public interface ChannelDataStrategy<T> {

    T getChannelData(DataChannelDTO dataChannelDTO, ProcessContext processContext);

    /**
     * 获取通道类型
     *
     * @return {@link com.xiaoazhai.common.enums.ChannelTypeEnum}
     */
    Integer getChannelType();
}
