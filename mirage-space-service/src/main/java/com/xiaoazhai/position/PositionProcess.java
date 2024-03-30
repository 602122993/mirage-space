package com.xiaoazhai.position;

import com.xiaoazhai.dto.DispatcherDTO;
import com.xiaoazhai.dto.PositionDTO;
import com.xiaoazhai.dto.ProcessContext;
import com.xiaoazhai.service.IPositionService;
import com.xiaoazhai.service.impl.ChannelService;
import com.xiaoazhai.service.impl.StrategyService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PositionProcess {

    @Resource
    private IPositionService positionService;

    @Resource
    private StrategyService strategyService;

    @Resource
    private ChannelService channelService;

    /**
     * 获取位置数据
     *
     * @param processContext 位置上下文
     * @param returnClass    返回类型
     * @return 位置数据
     */
    public <T> T getPositionData(ProcessContext processContext, Class<T> returnClass) {
        T returnObj = null;

        try {
            //构建上下文
            buildProcessContext(processContext);

            List<DispatcherDTO> dispatcherList = processContext.getPositionDTO().getDispatcherDTOS();
            for (DispatcherDTO dispatcherDTO : dispatcherList) {
                //判断策略是否通过
                if (strategyService.isPassStrategy(dispatcherDTO, processContext)) {
                    //获取通道数据
                    Object channelData = channelService.getChannelData(dispatcherDTO.getChannelMatch(), processContext);
                    if (channelData == null) {
                        log.info("通道获取数据为空");
                        continue;
                    }
                    returnObj = (T) channelData;
                }
            }


        } catch (Exception e) {
            log.error("获取位置信息失败");
        }
        return returnObj;
    }

    private void buildProcessContext(ProcessContext processContext) {
        PositionDTO positionDto = positionService.getPositionInfo(processContext.getPositionCode());
        processContext.setPositionDTO(positionDto);
    }

}
