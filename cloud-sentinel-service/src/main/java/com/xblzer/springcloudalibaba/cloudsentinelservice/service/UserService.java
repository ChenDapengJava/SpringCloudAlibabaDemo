package com.xblzer.springcloudalibaba.cloudsentinelservice.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author 行百里者
 * @date 2022-07-21 22:09
 */
@Service
public class UserService {

    /**
     * 标记为 Sentinel 资源
     */
    @SentinelResource(value = "getUser")
    public String getUser() {
        return "行百里者";
    }
}
