package com.xiaoazhai.dao.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiaoazhai.dao.pojo.DispatcherDataSourceChannel;
import com.xiaoazhai.dao.pojo.Strategy;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class DispatcherDTO implements Serializable {


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
    private List<StrategyDTO> stategyList;
    /**
     * 绑定数据源通道
     */
    private List<DispatcherDataSourceChannelDTO> channelList;

}
