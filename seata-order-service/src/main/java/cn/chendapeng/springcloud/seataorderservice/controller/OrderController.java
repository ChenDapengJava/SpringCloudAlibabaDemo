package cn.chendapeng.springcloud.seataorderservice.controller;


import cn.chendapeng.springcloud.seataorderservice.entity.Order;
import cn.chendapeng.springcloud.seataorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public String create(@RequestBody Order order) {
        orderService.createOrder(order);
        return "创建订单成功！";
    }
}
