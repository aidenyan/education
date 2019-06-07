package com.jimmy.mvc.common.base;

import com.jimmy.core.enums.ResultEnum;
import com.jimmy.mvc.common.enums.ResultCodeEnum;

public class ResultBuilder {

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>(ResultCodeEnum.OK);
        result.setResult(data);
        return result;
    }

    public static <T> Result<T> error(ResultEnum resultEnum, T data) {
        Result<T> result = new Result<>(resultEnum);
        result.setResult(data);
        return result;
    }

    public static <T> Result<T> error(ResultEnum resultEnum) {
        Result<T> result = new Result<>(resultEnum);
        return result;
    }
}
