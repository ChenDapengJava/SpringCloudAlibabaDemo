package cn.chendapeng.springcloud.loyaltyservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡是善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-27 18:29
 */
@RestController
@Slf4j
public class LoyaltyController {

    /**
     * 获取用户当前积分
     * @param id 用户id
     */
    @GetMapping("/score/{id}")
    public Integer getScore(@PathVariable("id") Long id) {
        log.info("获取用户 id={} 当前积分", id);
        return 1800;
    }

    /**
     * 为当前用户增加积分
     * @param id 用户id
     * @param lastScore 用户当前积分
     * @param addScore 要增加的积分
     */
    @GetMapping("/addScore")
    public Integer addScore(@RequestParam(value = "id") Long id,
                            @RequestParam(value = "lastScore") Integer lastScore,
                            @RequestParam(value = "addScore") Integer addScore) {
        log.info("用户 id={} 增加 {} 积分", id, addScore);
        return lastScore + addScore;
    }
}
