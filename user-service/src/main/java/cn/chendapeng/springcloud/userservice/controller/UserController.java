package cn.chendapeng.springcloud.userservice.controller;

import cn.chendapeng.springcloud.userservice.service.UserService;
import cn.chendapeng.springcloud.userservice.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
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

    @GetMapping("/info/{id}")
    public UserVO getUserInfo(@PathVariable("id") Long id) {
        log.info("Server port:{}", serverPort);
        UserVO userVO = userService.getUserInfo(id);
        // 测试网关负载均衡
        userVO.setServerPort(serverPort);
        return userVO;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
