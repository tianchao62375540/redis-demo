package com.leyou.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisDemoApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("test","hello world");
        String test = redisTemplate.opsForValue().get("test");
        System.out.println(test);
        /*ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set();*/
        BoundHashOperations<String, Object, Object> options = redisTemplate.boundHashOps("user:123");
        options.put("name","tianchao");
        options.put("like","bootball");
        Map<Object, Object> entries = options.entries();
        entries.put("address","沈阳");
        entries.clear();
        List<Object> values = options.values();
        for (Object value : values) {
            System.out.println(value);
        }
        Object name = options.get("name");
        System.out.println(name);
        System.out.println(options.entries());
    }

}
