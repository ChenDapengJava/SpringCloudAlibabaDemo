package cn.chendapeng.springcloud.sentinelservice.exception;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-17 15:36
 */
public class BusinessException extends RuntimeException {

    public static String getProductFallback(Long userId,
                                            Long productId,
                                            Integer categoryId) {
        return "getProduct 异常，fallback...";
    }
}
