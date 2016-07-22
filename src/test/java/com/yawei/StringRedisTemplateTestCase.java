package com.yawei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

   /* @Test
    public void testSaveHash(){
        stringRedisTemplate.opsForHash().put("user:4");
    }*/
}
