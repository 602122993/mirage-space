package com.xiaoazhai.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xiaoazhai.dao.dto.PositionDataDTO;
import com.xiaoazhai.dao.dto.ProcessContext;
import com.xiaoazhai.position.PositionProcess;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/mirage/space/entrance")
@Slf4j
public class MirageSpaceController {


    @Resource
    private PositionProcess positionProcess;

    /**
     * 获取位置数据
     *
     * @param positionCode 位置 code
     * @param extJson      扩展参数
     * @return 位置数据
     */
    @RequestMapping("/position/data")
    public PositionDataDTO getPositionData(String positionCode,
                                           @RequestParam(required = false) String extJson) {

        Map<String, String> extJsonMap = null;
        try {
            //extJson转换成 extJsonMap
            if (StrUtil.isNotEmpty(extJson)) {
                extJsonMap = JSONUtil.toBean(extJson, Map.class);
            }
        } catch (Exception e) {
            //转换异常
            log.error("extJson转换异常", e);
        }
        ProcessContext processContext = new ProcessContext();
        processContext.setPositionCode(positionCode);
        processContext.setExtJson(extJsonMap);
        PositionDataDTO positionDataDTO=  positionProcess.getPositionData(processContext,PositionDataDTO.class);
        return null;
    }
}
