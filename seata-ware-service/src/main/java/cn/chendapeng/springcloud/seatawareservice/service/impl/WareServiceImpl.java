package cn.chendapeng.springcloud.seatawareservice.service.impl;

import cn.chendapeng.springcloud.seatawareservice.entity.Ware;
import cn.chendapeng.springcloud.seatawareservice.dao.WareMapper;
import cn.chendapeng.springcloud.seatawareservice.service.WareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品库存表 服务实现类
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
@Service
@Slf4j
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {

    @Autowired
    private WareMapper wareMapper;

    @Override
    public void deductStock(Long skuId) {
        log.info("开始扣减库存，skuId={}", skuId);
        log.error("此处添加一个异常，模拟分布式事务发生：{}", skuId / 0);
        wareMapper.deductStock(skuId);
    }
}
