package cn.chendapeng.springcloud.openfeignservice.controller;

import cn.chendapeng.springcloud.openfeignservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-17 17:48
 */
@RestController
public class TestController {

    private ProductService productService;

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}