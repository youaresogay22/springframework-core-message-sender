package com.nhnacademy.edu.springframework.messagesender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DoorayMessageSender implements MessageSender {
    DoorayHookSender doorayHookSender;

    @Autowired
    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder()
                .botName("전석준")
                .text("안녕하세요")
                .build());
        return true;
    }
}
