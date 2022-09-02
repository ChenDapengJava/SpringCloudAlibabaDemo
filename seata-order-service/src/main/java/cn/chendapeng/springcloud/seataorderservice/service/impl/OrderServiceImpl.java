package cn.chendapeng.springcloud.seataorderservice.service.impl;

import cn.chendapeng.springcloud.seataorderservice.entity.Order;
import cn.chendapeng.springcloud.seataorderservice.dao.OrderMapper;
import cn.chendapeng.springcloud.seataorderservice.feign.WareFeignClient;
import cn.chendapeng.springcloud.seataorderservice.service.OrderService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private WareFeignClient wareFeignClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(Order order) {
        // 订单号
        String orderSn = IdWorker.getTimeId();
        order.setOrderSn(orderSn);
        order.setCreateTime(new Date());

        log.info("开始创建订单:{}", order);
        // 创建订单
        orderMapper.insert(order);

        // 此处异常使用 Spring 的 @Transactional 就可以解决
        //log.error("此处添加异常，模拟分布式事务出现：{}", order.getId() / 0);

        // 扣减库存
        wareFeignClient.deductStock(order.getSkuId());
        log.info("创建订单完成");
    }
}
