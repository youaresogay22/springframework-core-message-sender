package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
@Service
@Conditional(MainConfig.MessageSendServiceCondition.class)
public class MessageSendService {
    private final MessageSender messageSender;
    @Autowired
    public MessageSendService(MessageSender messageSender) {this.messageSender = messageSender;}
    public void doSendMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
