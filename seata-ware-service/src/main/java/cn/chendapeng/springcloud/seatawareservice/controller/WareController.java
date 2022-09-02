package cn.chendapeng.springcloud.seatawareservice.controller;


import cn.chendapeng.springcloud.seatawareservice.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品库存表 前端控制器
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
@RestController
@RequestMapping("/ware")
public class WareController {

    @Autowired
    private WareService wareService;

    @GetMapping("/deduct")
    public void deductStock(@RequestParam Long skuId) {
        wareService.deductStock(skuId);
    }
}
