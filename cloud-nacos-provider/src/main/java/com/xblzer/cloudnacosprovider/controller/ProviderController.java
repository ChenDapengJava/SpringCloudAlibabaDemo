package com.xblzer.cloudnacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 行百里者
 * @date 2022-06-30 18:29
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test-port")
    public String getServerPort() {
        return "Nacos Provider port:" + serverPort;
    }
}
