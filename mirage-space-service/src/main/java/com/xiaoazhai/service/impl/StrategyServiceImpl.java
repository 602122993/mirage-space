package com.xiaoazhai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoazhai.dao.pojo.Strategy;
import com.xiaoazhai.dao.mapper.StrategyMapper;
import com.xiaoazhai.dto.StrategyDTO;
import com.xiaoazhai.dto.SubStrategyDTO;
import com.xiaoazhai.service.IStrategyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoazhai.service.strategy.strategy.enums.StrategyBindTypeEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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


    @Override
    public List<StrategyDTO> queryStrategy(String bindType, Long bindId) {
        LambdaQueryWrapper<Strategy> queryWrapper = Wrappers.<Strategy>lambdaQuery().eq(Strategy::getBindType, bindType)
                .eq(Strategy::getBindId, bindId);
        //策略父类
        List<Strategy> strategyList = list(queryWrapper);
        List<StrategyDTO> resultList = StrategyDTO.fromStrategyList(strategyList);
        //填充子策略
        fillSubStrategy(resultList);
        return resultList;

    }

    private void fillSubStrategy(List<StrategyDTO> resultList) {
        List<Long> strategyIdList = resultList.
                stream().map(StrategyDTO::getId).toList();
        if (CollectionUtil.isNotEmpty(strategyIdList)) {
            List<Strategy> subStrategyList = list(Wrappers.<Strategy>lambdaQuery().in(Strategy::getBindId, strategyIdList).eq(Strategy::getBindType, StrategyBindTypeEnum.STRATEGY.getCode()));
            List<SubStrategyDTO> subStrategyDTOList = SubStrategyDTO.fromStrategyList(subStrategyList);
            Map<String, SubStrategyDTO> stringSubStrategyDTOMap = subStrategyDTOList.stream().collect(Collectors.toMap(SubStrategyDTO::getStrategyCode, Function.identity(), (k1, k2) -> k1));
            resultList.forEach(strategy -> strategy.setSubStrategyList(CollectionUtil.newArrayList(stringSubStrategyDTOMap.get(strategy.getStrategyCode()))));
        }
    }

    @Override
    @Transactional
    public void addOrUpdate(List<StrategyDTO> strategyDTOList) {
        //批量添加策略
        List<Long> strategyIdList = strategyDTOList.stream().map(StrategyDTO::getId).toList();
        deleteByIdList(strategyIdList);
        addBatch(strategyDTOList);
    }

    private void addBatch(List<StrategyDTO> strategyDTOList) {
        List<Strategy> saveList = new ArrayList<>(strategyDTOList.stream().map(StrategyDTO::toStrategy).toList());
        List<SubStrategyDTO> subStrategyList = strategyDTOList.stream().flatMap(strategyDTO -> strategyDTO.getSubStrategyList().stream()).toList();
        saveList.addAll(subStrategyList.stream().map(SubStrategyDTO::toStrategy).toList());
        saveBatch(saveList);
    }

    private void deleteByIdList(List<Long> strategyIdList) {
        if (CollectionUtil.isNotEmpty(strategyIdList)) {
            //删除父策略 sql
            LambdaQueryWrapper<Strategy> queryWrapper = Wrappers.<Strategy>lambdaQuery().in(Strategy::getId, strategyIdList);
            // 子策略 sql
            LambdaQueryWrapper<Strategy> subStrategyQueryWrapper = Wrappers.<Strategy>lambdaQuery().in(Strategy::getBindId, strategyIdList)
                    .eq(Strategy::getBindType, StrategyBindTypeEnum.STRATEGY.getCode());
            remove(queryWrapper);
            remove(subStrategyQueryWrapper);
        }
    }
}
