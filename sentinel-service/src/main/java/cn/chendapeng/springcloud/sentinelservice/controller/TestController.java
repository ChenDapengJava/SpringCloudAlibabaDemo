package cn.chendapeng.springcloud.sentinelservice.controller;

import cn.chendapeng.springcloud.sentinelservice.service.UserService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
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

    @GetMapping("/testSlowRate")
    public String testSlowRate() {
        //随机睡眠毫秒数
        int sleepMilliSeconds = (int) (Math.random() * 1000);
        try {
            TimeUnit.MILLISECONDS.sleep(sleepMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testSlowRate success! slept " + sleepMilliSeconds + "ms.";
    }

    @GetMapping("/testExceptionRate")
    public String testExceptionRate(Integer id) {
        if (id == 0) {
            throw new RuntimeException("id 不能等于0！");
        }
        return "testExceptionRate success!";
    }

    @GetMapping("/testException")
    public String testException(Integer id) {
        if (id == 0) {
            throw new RuntimeException("id 不能等于0！");
        }
        return "testException success!";
    }

    @GetMapping("/getUser")
    @SentinelResource("getUser")
    public String getUser() {
        return "getUser success!";
    }

    @GetMapping("/getOrder")
    @SentinelResource("getOrder")
    public String getOrder() {
        return "getOrder success!";
    }
}
