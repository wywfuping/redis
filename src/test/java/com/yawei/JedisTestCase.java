package com.yawei;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisTestCase {
    Jedis jedis=null;

    @Before
    public void start(){
        jedis = new Jedis("192.168.137.13");
    }

    @After
    public void close(){
        if(jedis!=null){
            jedis.close();
        }
    }
    @Test
    public void testSet(){
        jedis.set("wang","yawei");
    }
    @Test
    public void testGet(){
        jedis.get("wang");
    }

    @Test
    public void incrTest(){
        String key = "number:1";
        jedis.incr(key);
        System.out.println(jedis.get(key));
    }
    @Test
    public void incrByTest(){
        String key = "number:1";
        jedis.incrBy(key,80);
        System.out.println(jedis.get(key));
    }
    @Test
    public void incrByFolatTest(){
        String key = "money:1";
        jedis.incrByFloat(key,80);
        System.out.println(jedis.get(key));
    }
    @Test
    public void appendTest(){
        String key = "name:3";
        jedis.append(key,",Hello");
        System.out.println(jedis.get(key));
    }
    @Test
    public void msetTest(){
        jedis.mset("name:4","rose","address:4","china");
    }
    @Test
    public void mgetTest(){
        List<String> list=jedis.mget("name:4","address:4");
        for (String str : list){
            System.out.println(list);
        }
    }
}
