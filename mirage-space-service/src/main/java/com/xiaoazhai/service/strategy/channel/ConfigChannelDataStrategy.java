package com.xiaoazhai.service.strategy.channel;

import com.xiaoazhai.common.enums.ChannelTypeEnum;
import com.xiaoazhai.dao.dto.DataChannelDTO;
import com.xiaoazhai.dao.dto.ProcessContext;
import org.springframework.stereotype.Component;

/**
 * 从配置中获取数据策略
 */
@Component
public class ConfigChannelDataStrategy implements ChannelDataStrategy {
    @Override
    public Object getChannelData(DataChannelDTO dataChannelDTO, ProcessContext processContext) {
        return null;
    }

    @Override
    public Integer getChannelType() {
        return ChannelTypeEnum.CONFIG_DATA.getCode();
    }
}
