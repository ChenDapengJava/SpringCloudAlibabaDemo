package cn.chendapeng.springcloud.sentinelservice.response;

import cn.chendapeng.springcloud.common.response.ResponseCode;
import cn.chendapeng.springcloud.common.response.ResponseResult;
import cn.chendapeng.springcloud.sentinelservice.exception.HotKeyBlockedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * 控制器增强类，当控制器发生异常且符合类中定义的拦截异常类，将会被拦截
 * @author 行百里er
 * @since 2020-01-16 16:58
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 热点参数限流异常
     * @param e 异常对象
     * @return ResponseResult 全局异常响应
     */
    @ExceptionHandler(HotKeyBlockedException.class)
    public ResponseResult<String> hotKeyBlockedException(Exception e) {
        LOGGER.error("热点参数限流", e);
        return ResponseResult.fail(ResponseCode.HOT_KEY_BLOCKED.getCode(), ResponseCode.HOT_KEY_BLOCKED.getMessage());
    }

    /**
     * 未知的异常，统一处理
     * @param e 异常对象
     * @return ResponseResult全局异常响应
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<String> exception(Exception e) {
        LOGGER.error("未知异常", e);
        return ResponseResult.fail(ResponseCode.INTERNAL_ERROR.getCode(), ResponseCode.INTERNAL_ERROR.getMessage());
    }
}
