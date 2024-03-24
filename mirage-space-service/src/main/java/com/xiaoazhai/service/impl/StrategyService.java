package com.xiaoazhai.service.impl;

import com.xiaoazhai.dao.config.HasStrategy;
import com.xiaoazhai.dao.dto.ProcessContext;
import org.springframework.stereotype.Component;

@Component
public class StrategyService {

    public boolean isPassStrategy(HasStrategy hasStrategy, ProcessContext processContext) {
        return true;
    }

}
