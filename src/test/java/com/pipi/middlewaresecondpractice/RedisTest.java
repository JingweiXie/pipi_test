package com.pipi.middlewaresecondpractice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: XJW
 * @Date: 2023/4/11
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void one() {
        final String content = "robert test";
        final String key = "redis:template:one:string";
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, content);
        Object result = valueOperations.get(key);
        LOGGER.info("读取出来的内容：" + result);
    }
}
