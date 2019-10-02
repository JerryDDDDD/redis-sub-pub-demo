package com.layman.handler;

import org.springframework.stereotype.Component;

/**
 * @ClassName MessageReceiveHandler
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/29 16:23
 * @Version 3.0
 **/
@Component
public class MessageReceiveHandler {
    public void messagePush(String message){

        System.out.println("----------收到消息了message："+message);

    }
}
