package cn.chendapeng.springcloud.userservice.service.impl;

import cn.chendapeng.springcloud.userservice.service.UserService;
import cn.chendapeng.springcloud.userservice.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 15:31
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Map<Long, UserVO> userMap = new HashMap<>();

    static {
        userMap.put(1L, new UserVO("杰哥", 28, "真好康"));
        userMap.put(2L, new UserVO("老同志", 69, "耗子尾汁"));
    }

    @Override
    public UserVO getUserInfo(Long id) {
        return userMap.get(id);
    }
}
