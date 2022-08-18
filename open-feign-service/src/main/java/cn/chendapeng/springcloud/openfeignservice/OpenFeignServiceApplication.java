package cn.chendapeng.springcloud.openfeignservice;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignServiceApplication.class, args);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        // 开启详细日志
        return Logger.Level.FULL;
    }
}
