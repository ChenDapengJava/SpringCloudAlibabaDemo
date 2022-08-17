package cn.chendapeng.springcloud.sentinelservice.exception;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
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

    public Object getHotKey() {
        return hotKey;
    }
}
