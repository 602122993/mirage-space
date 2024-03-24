package com.xiaoazhai.service.strategy.channel.group;

import com.xiaoazhai.common.enums.ChannelGroupAssemblyEnum;
import com.xiaoazhai.common.enums.ChannelGroupTypeEnum;
import com.xiaoazhai.dao.dto.DispatcherChannelMatchDTO;
import com.xiaoazhai.dao.dto.ProcessContext;
import com.xiaoazhai.service.impl.ChannelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 优先级通道策略
 */
@Component
public class PriorityChannelGroupAssemblyStrategy implements ChannelGroupAssemblyStrategy {

    @Resource
    private ChannelService channelService;

    @Override
    public Integer getChannelGroupType() {
        return ChannelGroupAssemblyEnum.PRIORITY.getCode();
    }

    @Override
    public Object getChannelGroupData(DispatcherChannelMatchDTO dispatcherChannelMatch, ProcessContext processContext) {
        //优先级获取，遍历通道组中的通道，获取第一个有数据的通道
        List<DispatcherChannelMatchDTO> childChannel = dispatcherChannelMatch.getChildChannelList();
        for (DispatcherChannelMatchDTO dispatcherChannelMatchDTO : childChannel) {
            Object channelData = channelService.getChannelData(dispatcherChannelMatchDTO, processContext);
            if (channelData != null) {
                return channelData;
            }
        }
        return null;
    }
}
