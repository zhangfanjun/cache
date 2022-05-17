package com.zhang.caffeine.service;

import org.springframework.cache.annotation.Cacheable;

/**
 * 深圳金雅福控股集团有限公司
 *
 * @author zhangfanjun
 * @date 2022/5/17
 */
public interface CacheDemoService {
    @Cacheable(cacheNames = "CacheDemoService:getDataById", key = "#id")
    String getDataById(Integer id);
}
