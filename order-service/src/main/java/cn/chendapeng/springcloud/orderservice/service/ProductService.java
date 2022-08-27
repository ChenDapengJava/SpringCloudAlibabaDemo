package cn.chendapeng.springcloud.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡是善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-27 18:20
 */
@Service
@FeignClient("product-service")
public interface ProductService {

    @GetMapping("/product/price/{id}")
    BigDecimal getPrice(@PathVariable("id") Long id);
}
