package com.xiaoazhai.service.impl;

import com.xiaoazhai.common.enums.ChannelGroupAssemblyEnum;
import com.xiaoazhai.dao.dto.DataChannelDTO;
import com.xiaoazhai.dao.dto.DispatcherChannelMatchDTO;
import com.xiaoazhai.dao.dto.ProcessContext;
import com.xiaoazhai.service.strategy.channel.ChannelDataStrategy;
import com.xiaoazhai.service.strategy.channel.group.ChannelGroupAssemblyStrategy;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ChannelService {

    @Resource
    private StrategyService strategyService;

    @Resource
    List<ChannelDataStrategy> channelDataStrategyList;
    @Resource
    List<ChannelGroupAssemblyStrategy> channelGroupAssemblyStrategyList;
    private Map<Integer, ChannelDataStrategy> channelDataStrategyMap;

    private Map<Integer, ChannelGroupAssemblyStrategy> channelGroupAssemblyStrategyMap;

    @PostConstruct
    public void init() {
        channelDataStrategyMap = channelDataStrategyList.stream().collect(Collectors.toMap(ChannelDataStrategy::getChannelType, Function.identity()));
        channelGroupAssemblyStrategyMap = channelGroupAssemblyStrategyList.stream().collect(Collectors.toMap(ChannelGroupAssemblyStrategy::getChannelGroupType, Function.identity()));
    }

    /**
     * 获取通道数据
     *
     * @param dispatcherChannelMatch 通道匹配信息
     * @param processContext          上下文
     * @return 通道数据
     */

    public Object getChannelData(DispatcherChannelMatchDTO dispatcherChannelMatch, ProcessContext processContext) {
        boolean isPass = strategyService.isPassStrategy(dispatcherChannelMatch, processContext);
        if (isPass) {
            //通道策略通过
            if (dispatcherChannelMatch.isChannelGroup()) {
                //通道组走通道组的组合方式
                ChannelGroupAssemblyStrategy channelGroupAssembly = channelGroupAssemblyStrategyMap.get(dispatcherChannelMatch.getChannelGroupAssembly());
                return channelGroupAssembly.getChannelGroupData(dispatcherChannelMatch, processContext);
            } else {
                //非通道组，直接获取通道的数据
                ChannelDataStrategy channelDatastrategy = channelDataStrategyMap.get(dispatcherChannelMatch.getDataChannel().getChannelType());
                if (channelDatastrategy != null) {
                    return channelDatastrategy.getChannelData(dispatcherChannelMatch.getDataChannel(), processContext);
                }
            }
        }
        return null;
    }


}
