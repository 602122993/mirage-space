package com.xiaoazhai.dto;

import com.xiaoazhai.service.strategy.annotions.HasStrategy;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 流量分配表
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Getter
@Setter
public class DispatcherDTO implements Serializable , HasStrategy {


    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 位置编码
     */
    private String positionCode;

    /**
     * 调度器名称
     */
    private String dispatcherName;
    /**
     * 对应策略列表
     */
    private List<StrategyDTO> strategyList;
    /**
     * 绑定数据源的通道组
     */
    private DispatcherChannelMatchDTO channelMatch;

}
