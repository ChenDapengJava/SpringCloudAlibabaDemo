package cn.chendapeng.springcloud.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-06-30 18:29
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test-port")
    public String getServerPort() {
        return "Nacos Provider port:" + serverPort;
    }

}
