package com.xiaoazhai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoazhai.dao.dto.PositionDTO;
import com.xiaoazhai.dao.pojo.Position;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 位置信息表 服务类
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
public interface IPositionService extends IService<Position> {

    IPage<PositionDTO> queryPositionList(String searchItem, Integer pageNum, Integer pageSize);

    void addPosition(String name, String positionCode, String description, String developParam);
}
