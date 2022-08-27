package cn.chendapeng.springcloud.userservice.service;

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
 * @date 2022-08-27 18:38
 */
@Service
@FeignClient("loyalty-service")
public interface LoyaltyService {

    @GetMapping("/score/{id}")
    Integer getScore(@PathVariable("id") Long id);

    @GetMapping("/addScore")
    Integer addScore(@RequestParam(value = "id") Long id,
                     @RequestParam(value = "lastScore") Integer lastScore,
                     @RequestParam(value = "addScore") Integer addScore);
}
