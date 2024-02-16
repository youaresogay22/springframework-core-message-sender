package com.nhnacademy.edu.springframework.messagesender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.Dooray;
import com.nhnacademy.edu.springframework.messagesender.domain.User;

public class DoorayMessageSender implements MessageSender {
    DoorayHookSender doorayHookSender;

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
