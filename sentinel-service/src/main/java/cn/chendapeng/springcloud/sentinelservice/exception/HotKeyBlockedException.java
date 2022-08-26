package cn.chendapeng.springcloud.sentinelservice.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-17 11:21
 */
public class HotKeyBlockedException extends RuntimeException {

    private Object hotKey;

    public HotKeyBlockedException(Object hotKey) {
        super("热点参数 [" + hotKey + "]限流！");
        this.hotKey = hotKey;
    }

    public static String getProductBlockHandler(Long userId,
                                                Long productId,
                                                Integer categoryId,
                                                BlockException blockException) {
        throw new HotKeyBlockedException(userId);
    }

    public Object getHotKey() {
        return hotKey;
    }
}
