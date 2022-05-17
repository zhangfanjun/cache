package com.zhang.caffeine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 深圳金雅福控股集团有限公司
 *
 * @author zhangfanjun
 * @date 2022/5/17
 */
@Service
@Slf4j
public class CacheDemoServiceImpl implements CacheDemoService {

    @Override
//    @Cacheable(cacheNames = "CacheDemoServiceImpl:getDataById", key = "#id")
    public String getDataById(Integer id) {
        log.info("从数据库中查找，id为{}",id);
        return "hello caffeine cache";
    }

}
