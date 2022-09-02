package cn.chendapeng.springcloud.seataorderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-09-01 16:17
 */
@FeignClient("seata-ware-service")
public interface WareFeignClient {

    @GetMapping("/ware/deduct")
    void deductStock(@RequestParam(value = "skuId") Long skuId);
}
