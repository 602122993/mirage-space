package com.xiaoazhai.dto;

import com.xiaoazhai.service.strategy.annotions.HasStrategy;
import lombok.Data;

import java.util.List;

/**
 * 转发器数据源链接通道 dto
 */
@Data
public class DataChannelDTO implements HasStrategy {

    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 调度器ID
     */
    private Long dispatcherId;

    /**
     * 通道名称
     */
    private String channelName;

    /**
     * 通道类型
     *
     * @see com.xiaoazhai.common.enums.ChannelTypeEnum
     */
    private Integer channelType;
    /**
     * 通道绑定策略
     */
    private List<StrategyDTO> strategyList;
}
