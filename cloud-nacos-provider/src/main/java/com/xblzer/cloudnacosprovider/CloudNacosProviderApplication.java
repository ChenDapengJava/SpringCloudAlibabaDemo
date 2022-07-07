package com.xblzer.cloudnacosprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 行百里者
 * @since 2022.6.30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProviderApplication.class, args);
    }

}
