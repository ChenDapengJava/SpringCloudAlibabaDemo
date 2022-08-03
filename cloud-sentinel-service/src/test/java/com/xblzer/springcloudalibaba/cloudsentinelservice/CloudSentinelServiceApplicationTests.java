package com.xblzer.springcloudalibaba.cloudsentinelservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class CloudSentinelServiceApplicationTests {

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 1000));
        }
    }

}
