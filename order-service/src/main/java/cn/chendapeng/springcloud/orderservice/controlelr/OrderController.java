package cn.chendapeng.springcloud.orderservice.controlelr;

import cn.chendapeng.springcloud.orderservice.service.ProductService;
import cn.chendapeng.springcloud.orderservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 21:37
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    private UserService userService;

    private ProductService productService;

    @GetMapping("/create")
    public String createOrder(@RequestParam Long userId, @RequestParam Long productId) {
        log.info("常见订单参数，userId={}, productId={}", userId, productId);
        // 商品服务-获取价格
        BigDecimal price = productService.getPrice(productId);
        log.info("获得 price={}", price);
        // 用户服务-查询当前积分，增加积分
        Integer currentScore = userService.getScore(userId).getData();
        log.info("获得 currentScore={}", price);
        // 增加积分
        Integer addScore = price.intValue();
        Integer finalScore = userService.addScore(userId, currentScore, addScore).getData();
        log.info("下单成功，用户 id={} 最终积分：{}", userId, finalScore);
        return "下单成功，用户 id=" + userId + " 最终积分：" + finalScore;
    }

    @GetMapping("/info/{id}")
    public String getOrderInfo(@PathVariable("id") Long id) {
        return "order" + id + "，Server Port：" + serverPort;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
