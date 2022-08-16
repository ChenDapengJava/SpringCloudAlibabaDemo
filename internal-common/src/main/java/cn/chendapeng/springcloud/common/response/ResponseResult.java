package cn.chendapeng.springcloud.common.response;

import lombok.Data;

/**
 * 统一返回结果
 *
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-16 16:49
 */
@Data
public class ResponseResult<T> {
    /**
     * 状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 操作成功的返回
     * @param data 返回结果数据
     * @param <T> 数据类型泛型
     * @return 相应结果
     */
    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 操作失败的返回
     * @param code 状态码
     * @param message 提示信息
     * @param <T> 数据类型泛型
     * @return 失败操作的返回结果
     */
    public static <T> ResponseResult<T> fail(String code, String message) {
        return new ResponseResult<>(code, message);
    }
}
