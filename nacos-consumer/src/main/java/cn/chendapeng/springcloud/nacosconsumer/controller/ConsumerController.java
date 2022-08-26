package cn.chendapeng.springcloud.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-15 13:03
 */
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    @Value("${service-url.nacos-provider-service}")
    private String serviceUrl;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consume")
    public String consume() {
        return restTemplate.getForObject(serviceUrl + "/test-port", String.class);
    }
}
