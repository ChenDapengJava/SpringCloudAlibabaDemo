package cn.chendapeng.springcloud.nacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }

    /**
     * RefreshScope 注解支持 Nacos 配置自动刷新
     */
    @RestController
    @RefreshScope
    class ConfigController {

        @Value("${config.info}")
        private String configInfo;

        @GetMapping("/info")
        public String getInfo() {
            return configInfo;
        }
    }

}
