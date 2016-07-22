package com.yawei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringRedisTestCase {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("china", ",hello");
    }

    @Test
    public void testGet() {
        System.out.println(redisTemplate.opsForValue().get("china"));
    }


    @Test
    public void testIncr(){
        redisTemplate.opsForValue().increment("money:4",4.5);
        System.out.println(redisTemplate.opsForValue().get("money:4"));
    }
}
