package com.xblzer.cloudnacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConfigApplication.class, args);
    }

}
