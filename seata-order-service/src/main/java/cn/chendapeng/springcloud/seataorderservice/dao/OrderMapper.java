package cn.chendapeng.springcloud.seataorderservice.dao;

import cn.chendapeng.springcloud.seataorderservice.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 行百里er
 * @since 2022-09-01
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
