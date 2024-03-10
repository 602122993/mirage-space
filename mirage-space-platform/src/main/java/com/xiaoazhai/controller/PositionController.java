package com.xiaoazhai.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoazhai.dao.dto.PositionDTO;
import com.xiaoazhai.service.IPositionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mirage/space/platform/position")
public class PositionController {

    @Resource
    private IPositionService positionService;


    /**
     * 后台列表查询
     *
     * @param searchItem 查询条件
     * @param pageNum    页码
     * @param pageSize   每页数量
     * @return 分页数据
     */
    @RequestMapping("/list")
    public IPage<PositionDTO> positionList(@RequestParam(value = "searchItem", required = false) String searchItem,
                                           Integer pageNum,
                                           Integer pageSize) {
        return positionService.queryPositionList(searchItem, pageNum, pageSize);
    }

    /**
     * 添加位置
     *
     * @param name         位置名称
     * @param positionCode 位置编码
     * @param description  位置描述
     * @param developParam 开发参数
     */

    @RequestMapping("/add")
    public void addPosition(@RequestParam(value = "name") String name,
                            @RequestParam(value = "positionCode") String positionCode,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "developParam") String developParam) {
        positionService.addPosition(name, positionCode, description, developParam);
    }


}
