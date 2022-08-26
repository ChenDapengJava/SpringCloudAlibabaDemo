package cn.chendapeng.springcloud.openfeignservice.controller;

import cn.chendapeng.springcloud.openfeignservice.exception.BusinessException;
import cn.chendapeng.springcloud.openfeignservice.service.ProductService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-17 17:48
 */
@RestController
@Slf4j
public class TestController {

    private ProductService productService;

    @GetMapping("/product/{id}")
    @SentinelResource(value = "getProduct",
            blockHandler = "getProductBlock",
            fallback = "getProductFallback")
    public String getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    public String getProductBlock(Long id, BlockException e) {
        log.error("访问资源 getProduct 被限流，id={}", id);
        throw new BusinessException("C0002", "访问资源 getProduct 被限流");
    }

    public String getProductFallback(Long id) {
        log.error("访问资源 getProduct fallback");
        return "请稍后重试";
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
