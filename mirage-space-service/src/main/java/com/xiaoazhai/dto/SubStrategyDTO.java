package com.xiaoazhai.dto;

import com.xiaoazhai.common.annotations.JsonDetail;
import com.xiaoazhai.util.JsonDetailFormatUtil;
import com.xiaoazhai.dao.pojo.Strategy;
import com.xiaoazhai.service.strategy.strategy.StrategySchema;
import com.xiaoazhai.service.strategy.strategy.enums.SubStrategyCodeEnum;
import com.xiaoazhai.util.StrategySchemeUtil;
import lombok.Data;

import java.util.List;

/**
 * 调度器DTO
 */
@Data
public class SubStrategyDTO {

    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 绑定类型
     */
    private String bindType;

    /**
     * 绑定ID
     */
    private Long bindId;

    /**
     * 策略详情
     */
    private String strategyDetail;
    /**
     * 策略协议
     */
    @JsonDetail(isScheme = true)
    private StrategySchema strategySchema;
    /**
     * 策略配置
     */
    @JsonDetail
    private StrategyConfigDTO strategyConfig;
    /**
     * 策略code
     */
    private String strategyCode;
    /**
     * 策略code枚举
     */
    private SubStrategyCodeEnum subStrategyCodeEnum;
    /**
     * 子策略顺序
     */
    private Integer sort;
    /**
     * 策略白名单
     */
    @JsonDetail
    private List<Long> whiteList;

    public static List<SubStrategyDTO> fromStrategyList(List<Strategy> subStrategyList) {
        return subStrategyList.stream().map(SubStrategyDTO::fromStrategy).toList();
    }

    public Strategy toStrategy() {
        Strategy strategy = new Strategy();
        strategy.setStrategyCode(strategyCode);
        strategy.setBindType(bindType);
        strategy.setBindId(bindId);
        strategy.setSort(sort);
        subStrategyCodeEnum = SubStrategyCodeEnum.from(strategyCode);
        this.setStrategySchema(StrategySchemeUtil.parseStrategySchema(this.getStrategyConfig(), subStrategyCodeEnum));
        strategy.setStrategyDetail(JsonDetailFormatUtil.toJson(this));
        strategy.setId(id);
        return strategy;
    }

    private static SubStrategyDTO fromStrategy(Strategy strategy) {
        SubStrategyDTO strategyDTO = new SubStrategyDTO();
        strategyDTO.setStrategyCode(strategy.getStrategyCode());
        strategyDTO.setBindType(strategy.getBindType());
        strategyDTO.setBindId(strategy.getBindId());
        strategyDTO.setId(strategy.getId());
        strategyDTO.setSubStrategyCodeEnum(SubStrategyCodeEnum.from(strategy.getStrategyCode()));
        JsonDetailFormatUtil.fromJson(strategyDTO, strategy.getStrategyDetail(), strategyDTO.getSubStrategyCodeEnum().getStrategySchema());
        return strategyDTO;
    }
}
