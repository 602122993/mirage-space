package com.xiaoazhai.dao.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * 转发器数据源链接通道 dto
 */
@Data
public class DispatcherDataSourceChannelDTO {

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
     */
    private String channelType;
    /**
     * 通道绑定策略
     */
    private List<StrategyDTO> strategyList;
}
