package cn.chendapeng.springcloud.seataorderservice.service;

import cn.chendapeng.springcloud.seataorderservice.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
public interface OrderService extends IService<Order> {

    void createOrder(Order order);

}
