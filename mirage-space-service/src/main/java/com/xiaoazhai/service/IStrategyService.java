package com.xiaoazhai.service;

import com.xiaoazhai.dao.pojo.Strategy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoazhai.dto.StrategyDTO;

import java.util.List;

/**
 * <p>
 * 策略表，包括准入策略和频控策略 服务类
 * </p>
 *
 * @author xiaoazhai
 * @since 2024-03-09
 */
public interface IStrategyService extends IService<Strategy> {


    void addOrUpdate(List<StrategyDTO> strategyDTOList);
}
