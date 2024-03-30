package com.xiaoazhai.dto;

import lombok.Data;

import java.util.Map;

/**
 * 位置信息上下文
 */
@Data
public class ProcessContext {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 位置代码
     */
    private String positionCode;

    /**
     * 位置DTO
     */
    private PositionDTO positionDTO;

    /**
     * 跟踪ID
     */
    private String traceId;

    private Object returnObj;

    /**
     * 扩展Json映射
     */
    private Map<String, String> extJson;
}
