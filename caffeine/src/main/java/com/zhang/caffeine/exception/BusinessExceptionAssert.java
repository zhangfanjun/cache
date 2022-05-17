package com.zhang.caffeine.exception;

import com.zhang.caffeine.exception.base.AssertHandler;
import com.zhang.caffeine.exception.base.BaseException;

/**
 * 深圳金雅福控股集团有限公司
 *
 * @author zhangfanjun
 * @date 2022/5/17
 */
public interface BusinessExceptionAssert extends AssertHandler {

    /**
     * 重写方法返回自定义的异常，用于项目自定义的异常捕捉
     * BaseException也有默认的属性保存message，所以不重写就返回默认的异常
     * @param message 异常信息
     * @return 返回自定义的异常
     * @author zfj
     */
    @Override
    default BaseException newException(String message) {
        return new BusinessException(message);
    }
}
