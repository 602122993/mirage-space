package com.xiaoazhai.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoazhai.common.enums.CommonStatusEnum;
import com.xiaoazhai.dao.dto.PositionDTO;
import com.xiaoazhai.dao.pojo.Position;
import com.xiaoazhai.dao.mapper.PositionMapper;
import com.xiaoazhai.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 位置信息表 服务实现类
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Override
    public IPage<PositionDTO> queryPositionList(String searchItem, Integer pageNum, Integer pageSize) {
        Page<Position> result = page(new Page<>(pageNum, pageSize), Wrappers.<Position>lambdaQuery()
                .or(StringUtils.isNotBlank(searchItem), wrapper -> Wrappers.<Position>lambdaQuery().like(Position::getName, searchItem)
                        .like(Position::getPositionCode, searchItem)));
        return result.convert(PositionDTO::build);
    }

    @Override
    public void addPosition(String name, String positionCode, String description, String developParam) {
        Position position = new Position();
        position.setName(name);
        position.setPositionCode(positionCode);
        position.setDescription(description);
        position.setStatus(CommonStatusEnum.NORMAL.getStatus());
        position.setDevelopParam(developParam);
        save(position);
    }

    @Override
    public PositionDTO getPositionInfo(String positionCode) {
        return PositionDTO.build(getOne(Wrappers.<Position>lambdaQuery().eq(Position::getPositionCode, positionCode).eq(Position::getStatus, CommonStatusEnum.NORMAL.getStatus())));
    }
}
