package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSendService {
    private final MessageSender messageSender;

    @Autowired
    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean doSendMessage(User user, String message) {
        return messageSender.sendMessage(user, message);
    }
}
