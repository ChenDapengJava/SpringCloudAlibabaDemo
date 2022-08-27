package cn.chendapeng.springcloud.orderservice.service;

import cn.chendapeng.springcloud.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡是善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-27 18:24
 */
@Service
@FeignClient("user-service")
public interface UserService {

    /**
     * 由于 user-service 使用了统一返回结果，所以此处的返回值是 ResponseResult
     * @param id 用户id
     * @return ResponseResult<Integer>
     */
    @GetMapping("/user/score/{id}")
    ResponseResult<Integer> getScore(@PathVariable("id") Long id);

    /**
     * 由于 user-service 使用了统一返回结果，所以此处的返回值是 ResponseResult
     */
    @GetMapping("/user/addScore")
    ResponseResult<Integer> addScore(@RequestParam(value = "id") Long id,
                     @RequestParam(value = "lastScore") Integer lastScore,
                     @RequestParam(value = "addScore") Integer addScore);
}
