package com.xiaoazhai.service.impl;

import com.xiaoazhai.dao.pojo.PositionDataSource;
import com.xiaoazhai.dao.mapper.PositionDataSourceMapper;
import com.xiaoazhai.service.IPositionDataSourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据源表，用于记录不同数据源的信息 服务实现类
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Service
public class PositionDataSourceServiceImpl extends ServiceImpl<PositionDataSourceMapper, PositionDataSource> implements IPositionDataSourceService {

}
