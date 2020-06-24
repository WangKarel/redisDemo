package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/test")
    public void testRedis() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        User user = new User(uuid,"王志凯", 18, "男");
        String result = redisUtils.set("user" + uuid, user, 0);
        System.out.println(result);
    }
}
