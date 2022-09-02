package cn.chendapeng.springcloud.springbootadminserver.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-28 17:13
 */
@Component
public class ChenDapengHealthIndicator extends AbstractHealthIndicator {

    /**
     * 自定义健康检查输出信息
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up()
                .withDetail("status", "Oj8K!")
                .withDetail("whoami", "外星人")
                .withDetail("uptime", new Date());
    }
}
