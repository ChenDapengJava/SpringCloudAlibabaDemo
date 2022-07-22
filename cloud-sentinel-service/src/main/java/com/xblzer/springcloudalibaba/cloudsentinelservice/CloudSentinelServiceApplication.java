package com.xblzer.springcloudalibaba.cloudsentinelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudSentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSentinelServiceApplication.class, args);
    }

}
