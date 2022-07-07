package com.xblzer.cloudnacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 行百里者
 * @date 2022-06-30 18:36
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-provider-service}")
    private String serviceUrl;

    @GetMapping("/consume")
    public String consume() {
        return restTemplate.getForObject(serviceUrl + "/test-port", String.class);
    }
}
