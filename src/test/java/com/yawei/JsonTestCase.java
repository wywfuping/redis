package com.yawei;

import com.yawei.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JsonTestCase {

    //传入user对象练习
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    //对键值进行序列化（方式）
    @Before
    public void start() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    @Test
    public void testSetUser() {
        User user = new User(1, "tom", "US");
        redisTemplate.opsForValue().set("user:1", user);
    }

    @Test
    public void testGetUser() {
        User user = redisTemplate.opsForValue().get("user:1");
        System.out.println(user);
    }
}
