package com.zking.ssm.service.Impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends  baseTest{

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void dome(){

        redisTemplate.opsForValue().set("name","zs");

    }
}
