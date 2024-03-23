package com.xiaoazhai.position;

import cn.hutool.core.util.ReflectUtil;
import com.xiaoazhai.dao.dto.PositionDTO;
import com.xiaoazhai.dao.dto.PositionDataDTO;
import com.xiaoazhai.dao.dto.ProcessContext;
import com.xiaoazhai.service.IPositionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PositionProcess {

    @Resource
    private IPositionService positionService;

    /**
     * 获取位置数据
     *
     * @param processContext 位置上下文
     * @param returnClass    返回类型
     * @return 位置数据
     */
    public <T> T getPositionData(ProcessContext processContext, Class<T> returnClass) {
        Object returnObj = null;

        try {
            buildProcessContext(processContext);
            returnObj = ReflectUtil.newInstance(returnClass);
        } catch (Exception e) {
            log.error("获取位置信息失败");
        }
        return (T) returnObj;
    }

    private void buildProcessContext(ProcessContext processContext) {
        PositionDTO positionDto = positionService.getPositionInfo(processContext.getPositionCode());
        processContext.setPositionDTO(positionDto);
    }

}
