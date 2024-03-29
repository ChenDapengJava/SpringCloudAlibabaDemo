package cn.chendapeng.springcloud.seataorderservice.service.impl;

import cn.chendapeng.springcloud.seataorderservice.entity.Order;
import cn.chendapeng.springcloud.seataorderservice.dao.OrderMapper;
import cn.chendapeng.springcloud.seataorderservice.feign.WareFeignClient;
import cn.chendapeng.springcloud.seataorderservice.service.OrderService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional
    //@Transactional(rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("开始扣减库存，skuId={}", order.getSkuId());
        // 扣减库存
        wareFeignClient.deductStock(order.getSkuId());
        log.info("扣减库存完成，skuId={}", order.getSkuId());

        // 订单号
        String orderSn = IdWorker.getTimeId();
        order.setOrderSn(orderSn);
        order.setCreateTime(new Date());

        log.info("开始创建订单:{}", order);
        log.error("此处添加异常order.getId()此时为null，模拟分布式事务出现：{}", order.getId().toString());
        // 创建订单
        orderMapper.insert(order);

        log.info("创建订单完成");
    }
}
