package cn.chendapeng.springcloud.seatawareservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.chendapeng.springcloud.seatawareservice.dao")
public class SeataWareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataWareServiceApplication.class, args);
    }

}
