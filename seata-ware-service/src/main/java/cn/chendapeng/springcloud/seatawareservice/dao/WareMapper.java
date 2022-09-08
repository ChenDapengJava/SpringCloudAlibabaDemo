package cn.chendapeng.springcloud.seatawareservice.dao;

import cn.chendapeng.springcloud.seatawareservice.entity.Ware;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 商品库存表 Mapper 接口
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
@Mapper
public interface WareMapper extends BaseMapper<Ware> {

    @Update("update t_ware set stock=stock-1, update_time=now() where sku_id=#{skuId}")
    void deductStock(Long skuId);

}
