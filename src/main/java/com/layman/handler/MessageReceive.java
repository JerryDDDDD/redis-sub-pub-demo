package com.layman.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessageReceive
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/29 16:14
 * @Version 3.0
 **/
@Component
public class MessageReceive {

    @Autowired
    private MessageReceiveHandler messageReceiveHandler;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void receiveMessage(String message) {
        System.out.println(message);
        messageReceiveHandler.messagePush(message);
        redisTemplate.opsForHash().put("111", "123", "1111");
    }
}
