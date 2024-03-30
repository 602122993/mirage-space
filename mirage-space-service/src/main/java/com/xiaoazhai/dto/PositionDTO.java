package com.xiaoazhai.dto;

import com.xiaoazhai.dao.pojo.Position;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 位置信息表
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Getter
@Setter
public class PositionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 位置编码
     */
    private String positionCode;

    /**
     * 位置名称
     */
    private String name;

    /**
     * 位置描述
     */
    private String description;

    /**
     * 开发参数
     */
    private String developParam;
    /**
     * 转发器
     */
    private List<DispatcherDTO> dispatcherDTOS;

    public static PositionDTO build(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setPositionCode(position.getPositionCode());
        positionDTO.setName(position.getName());
        positionDTO.setDescription(position.getDescription());
        positionDTO.setDevelopParam(position.getDevelopParam());
        return positionDTO;
    }
}
