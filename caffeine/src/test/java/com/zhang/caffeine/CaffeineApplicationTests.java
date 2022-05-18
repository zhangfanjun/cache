package com.zhang.caffeine;

import com.zhang.caffeine.exception.BusinessExceptionEnum;
import com.zhang.caffeine.service.CacheDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.Assert;

import javax.annotation.Resource;


@SpringBootTest
class CaffeineApplicationTests {

    @Resource
    private CacheDemoService cacheDemoService;
    @Resource
    private CacheManager cacheManager;

    @Test
    void contextLoads() {
        String cacheName1 = "CacheDemoService:getDataById";
        String cacheName2 = "CacheDemoServiceImpl:getDataById";
        int id = 1;
        //第一次打印，service有日志
        cacheDemoService.getDataById(id);
        //接口缓存
        Cache cache1 = cacheManager.getCache(cacheName1);
        String value1 = cache1.get(id, String.class);
        System.out.println(cache1);
        System.out.println(value1);
        cache1.evictIfPresent(id);
        cache1.evict(id);
        cache1.clear();
        cache1.put(id,"新增");
        cache1.putIfAbsent(id,"新增2");

        //业务缓存
        Cache cache2 = cacheManager.getCache(cacheName2);
        String value2 = cache2.get(id, String.class);
        System.out.println(value2);
        //第二次调用，service没有日志打印
        cacheDemoService.getDataById(id);
    }

    @Test
    void test1(){
        String s = new String();
//        System.out.println("测试isNull判断");
//        BusinessExceptionEnum.NOT_EXIST.isNull(s);
//        System.out.println("测试异常信息定义");
//        BusinessExceptionEnum.NOT_EXIST.isNull(s,()->{
//            return "222";
//        });
        System.out.println("测试断言");
        BusinessExceptionEnum.NOT_EXIST.throwIfTrue(()->{
            return true;
        });
    }

}
