package cn.chendapeng.springcloud.openfeignservice.response;

import cn.chendapeng.springcloud.common.response.ResponseCode;
import cn.chendapeng.springcloud.common.response.ResponseResult;
import cn.chendapeng.springcloud.openfeignservice.exception.BusinessException;
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
     * 业务异常，统一处理
     * @param e 异常对象
     * @return ResponseResult 全局异常响应
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<String> businessException(BusinessException e) {
        LOGGER.info("code={}, message={}", e.getCode(), e.getMessage());
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }

}
