package cn.chendapeng.springcloud.openfeignservice.service.impl;

import cn.chendapeng.springcloud.common.response.ResponseCode;
import cn.chendapeng.springcloud.openfeignservice.exception.BusinessException;
import cn.chendapeng.springcloud.openfeignservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-19 14:55
 */
@Component
@Slf4j
public class ProductServiceImpl implements ProductService {

    /**
     * 调用远程服务 nacos-provider 的 product/{id} 接口失败后的处理方法
     *
     * @param id 参数 id
     * @return 返回
     */
    @Override
    public String getProductById(Long id) {
        log.error("调用接口 getProduct 失败，id={}", id);
        //return "OpenFeign 降级";
        throw new BusinessException(ResponseCode.RPC_ERROR.getCode(), ResponseCode.RPC_ERROR.getMessage());
    }
}
