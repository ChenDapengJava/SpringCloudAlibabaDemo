package cn.chendapeng.springcloud.userservice.service;

import cn.chendapeng.springcloud.userservice.vo.UserVO;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 15:30
 */
public interface UserService {

    UserVO getUserInfo(Long id);
}
