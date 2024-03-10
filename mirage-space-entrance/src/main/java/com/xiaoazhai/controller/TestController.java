package com.xiaoazhai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoazhai.dao.pojo.Position;
import com.xiaoazhai.service.IPositionService;
import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.xiaoazhai.dao.mapper")
public class TestController {


    @Resource
    private IPositionService positionService;
    @RequestMapping("/test")
    public Object test() {

        return   positionService.list();
    }
}
