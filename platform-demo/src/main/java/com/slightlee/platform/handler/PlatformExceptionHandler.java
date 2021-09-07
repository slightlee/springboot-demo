package com.slightlee.platform.handler;

import com.slightlee.platform.exception.PlatformException;
import com.slightlee.platform.util.Result;
import com.slightlee.platform.util.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestControllerAdvice
public class PlatformExceptionHandler {

    /**
     * 全局异常捕捉处理
     */
    @ExceptionHandler(value = {Exception.class})
    public Result handlerException(Exception exception, HttpServletRequest request) {
        log.error("请求路径uri={},系统内部出现异常:{}", request.getRequestURI(), exception);
        Result result = Result.error(ResultEnum.INTERNAL_SERVER_ERROR, exception.getLocalizedMessage());
        return result;
    }


    /**
     * 自定义异常-PlatformException
     */
    @ExceptionHandler(value = {PlatformException.class})
    public Result handlerCustomException(PlatformException exception, HttpServletRequest request) {
        log.error("请求路径uri={},出现异常:{}", request.getRequestURI(), exception);
        String errorMessage = exception.getMsg();
        Result result = Result.error(exception.getCode(), errorMessage);
        return result;
    }


    /**
     * 兼容Validation校验框架：忽略参数异常处理器
     */
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ApiResult<String> parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
//        log.error(e.getMessage(), e);
//        return ErrorResult.error(PARAMETER_EXCEPTION, "请求参数 " + e.getParameterName() + " 不能为空");
//    }

    /**
     * 兼容Validation校验框架：缺少请求体异常处理器
     */
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ErrorResult parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
//        log.error(e.getMessage(), e);
//        return ErrorResult.error(PARAMETER_EXCEPTION, "参数体不能为空");
//    }

    /**
     * 兼容Validation校验框架：参数效验异常处理器
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ErrorResult parameterExceptionHandler(MethodArgumentNotValidException e) {
//        log.error(e.getMessage(), e);
//        // 获取异常信息
//        BindingResult exceptions = e.getBindingResult();
//        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
//        if (exceptions.hasErrors()) {
//            List<ObjectError> errors = exceptions.getAllErrors();
//            if (!errors.isEmpty()) {
//                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
//                FieldError fieldError = (FieldError) errors.get(0);
//                return ErrorResult.error(PARAMETER_EXCEPTION, fieldError.getDefaultMessage());
//            }
//        }
//        return ErrorResult.error(PARAMETER_EXCEPTION, "请求参数校验异常");
//    }
}
