package com.zhang.caffeine.exception.base;

/**
 * 深圳金雅福控股集团有限公司
 *
 * @author zhangfanjun
 * @date 2022/5/18
 */
@FunctionalInterface
public interface AssertFunction {

    /**
     * 断言
     *
     * @return 断言结果
     * @author zfj
     * @date 2022/5/18
     */
    boolean check();
}
