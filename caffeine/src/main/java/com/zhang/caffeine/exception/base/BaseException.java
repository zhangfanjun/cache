package com.zhang.caffeine.exception.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础异常
 *
 * @author zhangfanjun
 * @date 2022/5/17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseException extends RuntimeException {
    /**
     * 异常信息
     */
    private String message;
}
