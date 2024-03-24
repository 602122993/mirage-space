package com.xiaoazhai.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DispatcherChannelMatch implements Serializable {

    /**
     * 主键ID，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 创建时间，自动生成
     */
    private LocalDateTime createTime;

    /**
     * 更新时间，自动更新
     */
    private LocalDateTime updateTime;
    /**
     * 状态1，正常 0，删除
     */
    private Integer status;
}
