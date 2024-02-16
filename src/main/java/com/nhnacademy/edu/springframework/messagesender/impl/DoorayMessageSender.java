package com.nhnacademy.edu.springframework.messagesender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.Dooray;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Primary
public class DoorayMessageSender implements MessageSender {
    DoorayHookSender doorayHookSender;

    @Bean
    public static DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3204376758577275363/3738651962004364986/HByzZBRuRu69-EUTsWR0tg");
    }

    @Autowired
    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    @Dooray
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder()
                .botName("전석준")
                .text(message)
                .build());
        return true;
    }
}
