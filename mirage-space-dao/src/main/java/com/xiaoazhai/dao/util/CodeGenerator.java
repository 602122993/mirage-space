package com.xiaoazhai.dao.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mirage_space", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("xiaoazhai")
                            .commentDate("yyyy-MM-dd")
                            .disableOpenDir(); // 指定输出目录
                })
                .packageConfig(builder -> {
                    Map<OutputFile, String> pathMap = new HashMap<>();
                    pathMap.put(OutputFile.entity,"/Users/zhaixiangyi/IdeaProjects/MirageSpace/mirage-space-dao/src/main/java/com/xiaoazhai/dao/pojo");
                    pathMap.put(OutputFile.mapper,"/Users/zhaixiangyi/IdeaProjects/MirageSpace/mirage-space-dao/src/main/java/com/xiaoazhai/dao/mapper");
                    pathMap.put(OutputFile.service,"/Users/zhaixiangyi/IdeaProjects/MirageSpace/mirage-space-service/src/main/java/com/xiaoazhai/service");
                    pathMap.put(OutputFile.serviceImpl,"/Users/zhaixiangyi/IdeaProjects/MirageSpace/mirage-space-service/src/main/java/com/xiaoazhai/service/impl");
                    pathMap.put(OutputFile.xml,"/Users/zhaixiangyi/IdeaProjects/MirageSpace/mirage-space-dao/src/main/java/com/xiaoazhai/dao/mapper/xml");
                    builder.parent("com.xiaoazhai")
                            .entity("dao.pojo")// 设置父包名
                            .mapper("dao.mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .pathInfo(pathMap); // 设置mapperXml生成路径
                })
                .strategyConfig(builder ->
                        builder.entityBuilder()
                                .enableLombok())
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
