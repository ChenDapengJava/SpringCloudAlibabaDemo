package cn.chendapeng.springcloud.openfeignservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-17 17:44
 */
@Service
@FeignClient(name = "nacos-provider")
public interface ProductService {

    /**
     * 调用远程服务 nacos-provider 的 product/{id} 接口
     * @param id 参数 id
     * @return 返回
     */
    @GetMapping("/product/{id}")
    String getProductById(@PathVariable("id") Long id);
}
