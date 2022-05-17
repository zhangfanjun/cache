package com.zhang.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * EnableCaching开启本地缓存
 * 配置缓存管理器，可以配置多个
 * @author zfj
 */
@EnableCaching
@Configuration
public class CaffeineConfig {

    /**
     * 配置缓存管理器
     * @author zfj
     */
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                        //回收策略，失效时间
                        .expireAfterWrite(10, TimeUnit.MINUTES)
                        //初始化大小
                        .initialCapacity(100)
                        //回收策略，最大支持缓存数，当配置支持数为0的时候关闭本地缓存
                        .maximumSize(10000L)
                        //缓存填充策略（当value为null时候进行填充），通过createExpensiveGraph方法同步加载  buildAsync是异步加载
//                .buildAsync(key ->)
//                        .build(key -> createExpensiveGraph(key))
        );
        return cacheManager;
    }
}
