package com.jimmy.mvc.common.config;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 统一处理异常
 *
 * @author zhangjie
 */
@SuppressWarnings("Duplicates")
@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {



    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("Parameter validation failed:{}", e.getMessage(), e);
        // 只给出第一个校验出错的字段的错误信息
        BindingResult bindingResult = e.getBindingResult();
        FieldError error = bindingResult.getFieldError();
        String defaultMessage = error.getDefaultMessage();
        Result<Void> result = ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        result.setMessage(defaultMessage);
        return result;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Result<Void> handleBindException(BindException e) {
        log.warn("Parameter validation failed:{}", e.getMessage(), e);
        // 只给出第一个校验出错的字段的错误信息
        BindingResult bindingResult = e.getBindingResult();
        FieldError error = bindingResult.getFieldError();
        assert error != null;
        String defaultMessage = error.getDefaultMessage();
        Result<Void> result = ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        result.setMessage(defaultMessage);
        return result;
    }


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Void> handleValidationException(ConstraintViolationException e) {
        log.warn("Parameter validation failed:{}", e.getMessage(), e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        Result<Void> result = ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        result.setMessage(message);
        return result;
    }


}