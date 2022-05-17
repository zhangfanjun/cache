package com.zhang.caffeine.exception;

import com.zhang.caffeine.exception.base.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常信息枚举类，
 * 好处在于枚举可以定义多个参数，并且不需要new对象，直接使用
 *
 * @author zhangfanjun
 * @date 2022/5/17
 */
@Getter
@AllArgsConstructor
public enum BusinessExceptionEnum implements BusinessExceptionAssert {
    NOT_FOUND(500, "没有找到"),
    NOT_EXIST(500,"不存在"),;

    private int code;
    private String message;

    @Override
    public BaseException newException() {
        return new BusinessException(code,message);
    }
}
