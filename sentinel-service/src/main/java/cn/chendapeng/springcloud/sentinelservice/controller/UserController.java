package cn.chendapeng.springcloud.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-15 16:52
 */
@RestController
@Slf4j
public class UserController {

    @GetMapping("/getProduct")
    @SentinelResource("getProduct")
    public String getProduct(@RequestParam(value = "userId", required = false) Long userId,
                             @RequestParam(value = "productId", required = false) Long productId,
                             @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        log.info("getProduct param userId={},productId={},categoryId={}", userId, productId, categoryId);
        return "getProduct success";
    }
}
