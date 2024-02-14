package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
@Service
@Conditional(MainConfig.MessageSendServiceCondition.class)
public class MessageSendService {
    private MessageSender messageSender;
    @Autowired @SMS
    public MessageSendService(MessageSender messageSender) {this.messageSender = messageSender;}
    public MessageSendService(){};
    public void setSmsMessageSender(MessageSender messageSender) {this.messageSender = messageSender;}
    public void doSendMessage(User user, String message){
        messageSender.sendMesssage(user, message);
    }
}
