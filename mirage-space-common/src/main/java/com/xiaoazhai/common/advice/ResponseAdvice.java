package com.xiaoazhai.common.advice;

import com.xiaoazhai.common.result.ActionResult;
import com.xiaoazhai.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 统一包装
     *
     * @param o                  返回对象
     * @param methodParameter    方法参数
     * @param mediaType          媒体类型
     * @param aClass             类
     * @param serverHttpRequest  请求
     * @param serverHttpResponse 响应
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        /**
         * String、ActionResult不需要再包一层（不想包一层ActionResult对象的可以在这里把这个对象过滤掉）
         */
        if (o instanceof String || o instanceof ActionResult) {
            return o;
        }
        return ActionResult.defaultOk(o);
    }

    /**
     * 系统内部异常捕获
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return ActionResult.defaultFail(ResultCodeEnum.RC500);
    }


    /**
     * 忽略参数异常处理器;触发例子:带有@RequestParam注解的参数未给参数
     *
     * @param e 忽略参数异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
        log.error("缺少Servlet请求参数异常", e);
        return ActionResult.defaultFail(ResultCodeEnum.RC1004);
    }

    /**
     * 缺少请求体异常处理器;触发例子:不给请求体参数
     *
     * @param e 缺少请求体异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        log.error("参数请求体异常", e);
        return ActionResult.defaultFail(ResultCodeEnum.RC1005);
    }


    /**
     * 统一处理请求参数绑定错误(实体对象传参);
     *
     * @param e BindException
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Object validExceptionHandler(BindException e) {
        log.error("方法参数绑定错误(实体对象传参)", e);
        return ActionResult.defaultFail(ResultCodeEnum.RC1006);
    }

    /**
     * 统一处理请求参数绑定错误(实体对象请求体传参);
     *
     * @param e 参数验证异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object parameterExceptionHandler(MethodArgumentNotValidException e) {
        log.error("方法参数无效异常(实体对象请求体传参)", e);
        return ActionResult.defaultFail(ResultCodeEnum.RC1007);
    }

}
