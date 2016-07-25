package com.yawei;

import com.google.gson.Gson;
import com.yawei.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StringRedisTemplateTestCase {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSaveUser(){
        stringRedisTemplate.opsForValue().set("user:2","wang");
    }

    @Test
    public void testSaveSet(){
        stringRedisTemplate.opsForSet().add("user:3","zhang","zhao","liu");
    }

    @Test
    public void testGetFromSet(){
        Set<String> users=stringRedisTemplate.opsForSet().members("user:3");
        for(String str : users){
            System.out.println(str);
        }
    }

    @Test
    public void testSaveHash(){
        //stringRedisTemplate.opsForHash().put("user:4","name","yawei");
        Map<String,String> map = new HashMap<>();
        map.put("name","wanglei");
        map.put("address","zhengzhou");
        stringRedisTemplate.opsForHash().putAll("user:4",map);
    }
    @Test
    public void testSave(){
        User user = new User(3,"wangshi","china");
        stringRedisTemplate.opsForValue().set("user:5",new Gson().toJson(user));
    }
    @Test
    public void testGetUser(){
        String json = stringRedisTemplate.opsForValue().get("user:5");
        User user = new Gson().fromJson(json,User.class);
        System.out.println(user);
    }
}
