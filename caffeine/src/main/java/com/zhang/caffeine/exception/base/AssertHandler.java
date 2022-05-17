package com.zhang.caffeine.exception.base;


import org.springframework.util.Assert;

import java.util.function.Supplier;

/**
 * 这里模仿Assert的isNull的写法，
 * Assert是抽象类，这里采用接口，所以需要default定义
 * 唯一不同的地方是这里不定义具体的异常，该异常由各自的处理器自定义
 *
 * @author zhangfanjun
 * @date 2022/5/17
 * @see Assert#isNull(Object, String) 断言判断null
 */
public interface AssertHandler {


    /**
     * 没有入参的异常，这个处理主要是返回枚举的参数进行创建异常
     *
     * @return 异常
     * @author zfj
     * @date 2022/5/17
     */
    BaseException newException();

    /**
     * 提供默认的异常返回，如果需要返回项目的自定义异常，就需要重写该方法
     *
     * @param message 异常的信息
     * @return 自定义的基础异常
     * @author zfj
     */
    default BaseException newException(String message) {
        return new BaseException(message);
    }

    /**
     * 基础方法
     * Supplier提供get方法
     *
     * @param messageSupplier Supplier表达式
     * @return 字符串
     * @author zfj
     */
    default String nullSafeGet(Supplier<String> messageSupplier) {
        return messageSupplier != null ? messageSupplier.get() : null;
    }

    /**
     * 判断null，这个时候采用自定义的异常来进行处理
     *
     * @param object 入参
     * @author zfj
     */
    default void isNull(Object object) {
        if (object != null) {
            throw newException();
        }
    }

    /**
     * 判断null
     *
     * @param object  入参
     * @param message 异常信息
     * @author zfj
     */
    default void isNull(Object object, String message) {
        if (object != null) {
            throw newException(message);
        }
    }

    /**
     * 判断null
     *
     * @param object          入参
     * @param messageSupplier 异常信息表达式
     * @author zfj
     */
    default void isNull(Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw newException(nullSafeGet(messageSupplier));
        }
    }
}
