package com.xiaoazhai.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CommonResourceDTO {
    /**
     * 资源id
     */
    private String resourceId;
    /**
     * 标题
     */
    private String title;

    /**
     * 资源的副标题
     */
    private String subTitle;

    /**
     * 与资源相关的操作的URL
     */
    private String actionUrl;

    /**
     * 资源的图标
     */
    private String icon;

    /**
     * 资源的类型
     */
    private String type;

    /**
     * 资源的作者
     */
    private String author;

    /**
     * 资源的封面图像
     */
    private String coverImg;

    /**
     * 与资源相关的标签
     */
    private String tag;

    /**
     * 包含关于资源的额外扩展信息的映射
     */
    private Map<String, String> extMap;
}
