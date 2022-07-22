package com.xblzer.springcloudalibaba.cloudsentinelservice.controller;

import com.xblzer.springcloudalibaba.cloudsentinelservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 行百里者
 * @date 2022-07-20 17:42
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/test-a")
    public String testSentinelA() {
        /*try {
            // 睡 0.8s，模拟线程做事，否则可能会因为线程执行速度过快无法达到测试效果
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // 调用 userService 的 getUser 方法，该方法被标记为 Sentinel 资源
        String user = userService.getUser();
        return "hello test-a user:" + user + "!";
    }

    @GetMapping("/test-b")
    public String testSentinelB() {
        // 调用 userService 的 getUser 方法，该方法被标记为 Sentinel 资源
        String user = userService.getUser();
        return "hello test-b user:" + user + "!";
    }

    @GetMapping("/test-c")
    public String testSentinelC() {
        return "hello , Sentinel C";
    }
}
