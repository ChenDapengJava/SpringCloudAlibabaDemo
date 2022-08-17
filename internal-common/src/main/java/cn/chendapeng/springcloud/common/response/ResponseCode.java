package cn.chendapeng.springcloud.common.response;

/**
 * 返回状态码
 *
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-16 16:50
 */
public enum ResponseCode {

    /**
     * 操作成功
     */
    SUCCESS("00000", "操作成功"),

    /**
     * 系统内部异常
     */
    INTERNAL_ERROR("B0001", "系统执行出错"),

    /**
     * 热点参数限流
     */
    HOT_KEY_BLOCKED("B0002", "热点参数限流");

    /**
     * 状态码
     */
    private final String code;

    /**
     * 提示信息
     */
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
