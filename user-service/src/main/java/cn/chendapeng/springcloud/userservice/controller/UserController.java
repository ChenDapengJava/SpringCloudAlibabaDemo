package cn.chendapeng.springcloud.userservice.controller;

import cn.chendapeng.springcloud.userservice.service.LoyaltyService;
import cn.chendapeng.springcloud.userservice.service.UserService;
import cn.chendapeng.springcloud.userservice.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 15:10
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    private UserService userService;

    private LoyaltyService loyaltyService;

    @GetMapping("/score/{id}")
    public Integer getScore(@PathVariable("id") Long id) {
        return loyaltyService.getScore(id);
    }

    @GetMapping("/addScore")
    public Integer addScore(@RequestParam Long id,
                            @RequestParam Integer lastScore,
                            @RequestParam Integer addScore) {
        return loyaltyService.addScore(id, lastScore, addScore);
    }

    @GetMapping("/info/{id}")
    public UserVO getUserInfo(@PathVariable("id") Long id, HttpServletRequest request) {
        log.info("Server port:{}", serverPort);
        UserVO userVO = userService.getUserInfo(id);
        // 测试网关负载均衡
        userVO.setServerPort(serverPort);
        // 测试网关的 AddRequestHeader 过滤器
        log.info("获取网关 AddRequestHeader 过滤器添加的请求头 X-Request-Home={}", request.getHeader("X-Request-Home"));
        return userVO;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setLoyaltyService(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }
}
