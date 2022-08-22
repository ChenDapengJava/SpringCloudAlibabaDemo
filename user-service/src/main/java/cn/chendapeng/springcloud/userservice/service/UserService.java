package cn.chendapeng.springcloud.userservice.service;

import cn.chendapeng.springcloud.userservice.vo.UserVO;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 15:30
 */
public interface UserService {

    UserVO getUserInfo(Long id);
}
