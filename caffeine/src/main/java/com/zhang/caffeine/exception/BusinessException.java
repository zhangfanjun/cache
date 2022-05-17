package com.zhang.caffeine.exception;

import com.zhang.caffeine.exception.base.BaseException;
import lombok.Data;

/**
 * 深圳金雅福控股集团有限公司
 *
 * @author zhangfanjun
 * @date 2022/5/17
 */
@Data
public class BusinessException extends BaseException {
    /**
     * 异常的
     */
    private int code = 500;
    /**
     * 异常信息
     */
    private String message;

    public BusinessException() {
    }

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
