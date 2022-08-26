package cn.chendapeng.springcloud.orderservice.controlelr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 21:37
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/info/{id}")
    public String getOrderInfo(@PathVariable("id") Long id) {
        return "order" + id + "，Server Port：" + serverPort;
    }
}
