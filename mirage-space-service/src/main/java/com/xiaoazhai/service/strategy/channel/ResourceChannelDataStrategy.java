package com.xiaoazhai.service.strategy.channel;

import com.xiaoazhai.dao.dto.DataChannelDTO;
import com.xiaoazhai.dao.dto.ProcessContext;
import com.xiaoazhai.dao.dto.ResourceSortDTO;
import org.springframework.stereotype.Component;

/**
 * 排序通道策略
 */
@Component
public class ResourceChannelDataStrategy implements ChannelDataStrategy<ResourceSortDTO> {
    @Override
    public ResourceSortDTO getChannelData(DataChannelDTO dataChannelDTO, ProcessContext processContext) {
        return null;
    }

    @Override
    public Integer getChannelType() {
        return null;
    }
}
