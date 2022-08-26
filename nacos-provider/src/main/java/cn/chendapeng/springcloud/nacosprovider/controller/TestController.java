package cn.chendapeng.springcloud.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-06-30 18:29
 */
@RestController
public class TestController {

    private final static Map<Long, String> PRODUCT_MAP = new HashMap<>();

    static {
        PRODUCT_MAP.put(1L, "香飘飘奶茶");
        PRODUCT_MAP.put(2L, "雀巢咖啡");
        PRODUCT_MAP.put(3L, "百事可乐");
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test-port")
    public String getServerPort() {
        return "Nacos Provider port:" + serverPort;
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id) {
        // 添加 sleep 时间，模拟超时连接
        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return serverPort + "：" + PRODUCT_MAP.get(id);
    }

}
