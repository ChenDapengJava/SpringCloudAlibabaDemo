package cn.chendapeng.springcloud.sentinelservice.controller;

import cn.chendapeng.springcloud.sentinelservice.exception.BusinessException;
import cn.chendapeng.springcloud.sentinelservice.exception.HotKeyBlockedException;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-15 16:52
 */
@RestController
@Slf4j
public class UserController {

    @GetMapping("/getProduct")
    @SentinelResource(value = "getProduct",
            blockHandlerClass = HotKeyBlockedException.class,
            blockHandler = "getProductBlockHandler",
            fallbackClass = BusinessException.class,
            fallback = "getProductFallback"
    )
    public String getProduct(@RequestParam(value = "userId", required = false) Long userId,
                             @RequestParam(value = "productId", required = false) Long productId,
                             @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        log.info("getProduct param userId={},productId={},categoryId={}", userId, productId, categoryId);
        // 测试 fallback
        if (productId != null && productId < 0) {
            throw new BusinessException();
        }
        return "getProduct success";
    }

    // 限流处理放到 HotKeyBlockedException 类中
//    public String getProductBlockHandler(Long userId,
//                                         Long productId,
//                                         Integer categoryId,
//                                         BlockException blockException) {
//        throw new HotKeyBlockedException(userId);
//    }

//    public String getProductBlockHandler(Long userId,
//                                         Long productId,
//                                         Integer categoryId,
//                                         BlockException blockException) {
//        return "热点参数 userId=" + userId + " 限流！";
//    }
}
