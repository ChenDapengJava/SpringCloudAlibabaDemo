package cn.chendapeng.springcloud.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-27 18:17
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/price/{id}")
    public BigDecimal getPrice(@PathVariable("id") Long id) {
        if (id == 1) {
            return new BigDecimal("5899");
        }
        return new BigDecimal("5999");
    }
}
