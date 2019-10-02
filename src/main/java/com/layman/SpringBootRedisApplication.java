package com.layman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName SpringBootRedisApplication
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/29 15:57
 * @Version 3.0
 **/
@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootRedisApplication.class, args);
        StringRedisTemplate stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
        stringRedisTemplate.convertAndSend("messagepush", "helloMessage");
        stringRedisTemplate.convertAndSend("messagepush3", "helloMessage 3");
    }
}
