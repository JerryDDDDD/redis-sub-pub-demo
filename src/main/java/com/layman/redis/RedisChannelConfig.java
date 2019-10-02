package com.layman.redis;

import com.layman.handler.MessageReceive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @ClassName RedisChannelConfig
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/29 16:10
 * @Version 3.0
 **/
@Configuration
public class RedisChannelConfig {

    @Bean
    RedisMessageListenerContainer container (RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("messagepush"));
        container.addMessageListener(listenerAdapter, new PatternTopic("messagepush3"));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceive receive) {
        return new MessageListenerAdapter(receive, "receiveMessage");
    }

//    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
