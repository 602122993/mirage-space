package com.xiaoazhai.dao.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiaoazhai.common.enums.ChannelGroupAssemblyEnum;
import com.xiaoazhai.common.enums.ChannelGroupTypeEnum;
import com.xiaoazhai.dao.config.HasStrategy;
import com.xiaoazhai.dao.pojo.DataChannel;
import com.xiaoazhai.dao.pojo.DispatcherChannelMatch;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DispatcherChannelMatchDTO implements Serializable, HasStrategy {

    /**
     * 主键ID，自增
     */
    private Long id;
    /**
     * 调度器ID
     */
    private Long dispatcherId;
    /**
     * 通道 id
     */
    private Long channelId;
    /**
     * 通道组数据获取方式，
     *
     * @see ChannelGroupTypeEnum
     */
    private Integer groupType;
    /**
     * 通道组中子通道的数据
     */
    private List<DispatcherChannelMatchDTO> childChannelList;
    /**
     * 策略列表
     */
    private List<StrategyDTO> strategyList;

    /**
     * 通道信息
     */
    private DataChannelDTO dataChannel;

    /**
     * 获取通道组组合数据方式
     *
     * @see ChannelGroupAssemblyEnum
     */
    private Integer channelGroupAssembly;

    public boolean isChannelGroup() {
        return groupType != ChannelGroupTypeEnum.NO_GROUP.getCode();
    }

    public ChannelGroupAssemblyEnum getChannelGroupAssemblyEnum() {
        return ChannelGroupAssemblyEnum.getEnumByCode(channelGroupAssembly);
    }
}
