package cn.chendapeng.springcloud.seatawareservice.service;

import cn.chendapeng.springcloud.seatawareservice.entity.Ware;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品库存表 服务类
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
public interface WareService extends IService<Ware> {

    void deductStock(Long skuId);
}
