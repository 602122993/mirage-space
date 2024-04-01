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
            Map<Long,List<SubStrategyDTO>> subStrategyMap = subStrategyDTOList.stream().collect(Collectors.groupingBy(SubStrategyDTO::getBindId));
            resultList.forEach(strategyDTO -> strategyDTO.setSubStrategyList(subStrategyMap.get(strategyDTO.getId())));
        }
    }

    @Override
    public void addOrUpdate(List<StrategyDTO> strategyDTOList) {
        //批量添加策略
        List<StrategyDTO> saveList = strategyDTOList.stream().filter(strategyDTO -> strategyDTO.getId() == null).toList();
        List<StrategyDTO> updateList = strategyDTOList.stream().filter(strategyDTO -> strategyDTO.getId() != null).toList();
        if (CollectionUtil.isNotEmpty(saveList)) {
            addBatch(saveList);
        }
        if (CollectionUtil.isNotEmpty(updateList)) {
            updateBatch(updateList);
        }
    }

    private void updateBatch(List<StrategyDTO> list) {
        List<Strategy> strategyList = list.stream().map(StrategyDTO::toStrategy).toList();
        //父策略直接更新
        updateBatchById(strategyList);
        List<SubStrategyDTO> subStrategyList = list.stream().flatMap(strategyDTO -> strategyDTO.fetchSubStrategyListWithBindId().stream()).toList();
        List<Long> subStrategyIdList = subStrategyList.stream().map(SubStrategyDTO::getId).toList();
        //子策略先删除后更新
        removeByIds(subStrategyIdList);
        saveBatch(subStrategyList.stream().map(SubStrategyDTO::toStrategy).toList());
    }

    //todo 待优化
    private void addBatch(List<StrategyDTO> strategyDTOList) {
        List<Strategy> strategyList = strategyDTOList.stream().map(StrategyDTO::toStrategy).toList();
        saveBatch(strategyList);
        Map<String,Long> strategyCodeIdMap  = strategyList.stream().collect(Collectors.toMap(Strategy::getStrategyCode,Strategy::getId));
        List<SubStrategyDTO> subStrategyList = strategyDTOList.stream().peek(strategyDTO -> strategyDTO.setId(strategyCodeIdMap.get(strategyDTO.getStrategyCode())))
                .flatMap(strategyDTO -> strategyDTO.fetchSubStrategyListWithBindId().stream()).toList();
        saveBatch(subStrategyList.stream().map(SubStrategyDTO::toStrategy).toList());
    }

}
