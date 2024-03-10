package com.xiaoazhai.service.impl;

import com.xiaoazhai.dao.pojo.Strategy;
import com.xiaoazhai.dao.mapper.StrategyMapper;
import com.xiaoazhai.service.IStrategyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 策略表，包括准入策略和频控策略 服务实现类
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
@Service
public class StrategyServiceImpl extends ServiceImpl<StrategyMapper, Strategy> implements IStrategyService {

}
