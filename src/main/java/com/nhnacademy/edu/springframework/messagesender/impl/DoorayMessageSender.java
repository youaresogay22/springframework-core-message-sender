package com.nhnacademy.edu.springframework.messagesender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component @Primary
public class DoorayMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), "${hookUrl}")
                .send(DoorayHook.builder()
                        .botName("전석준")
                        .text("안녕하세요")
                        .build());
    }
}
