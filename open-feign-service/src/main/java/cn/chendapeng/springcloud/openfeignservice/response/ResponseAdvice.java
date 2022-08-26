package cn.chendapeng.springcloud.openfeignservice.response;

import cn.chendapeng.springcloud.common.response.ResponseResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-16 16:55
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    private ObjectMapper objectMapper;

    /**
     * 是否开启功能
     * @param methodParameter 方法的参数
     * @param aClass 类
     * @return true：开启，false：不开启
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 处理返回结果
     * @param o 实例对象
     * @param methodParameter 方法参数
     * @param mediaType 媒体类别
     * @param aClass 类对象
     * @param request 请求
     * @param response 相应
     * @return 处理结果json
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        //处理字符串类型数据
        if (o instanceof String) {
            try {
                return objectMapper.writeValueAsString(ResponseResult.success(o));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //如果返回类型o已经封装成ResponseResult了，直接返回
        if (o instanceof ResponseResult) {
            return o;
        }
        return ResponseResult.success(o);
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
