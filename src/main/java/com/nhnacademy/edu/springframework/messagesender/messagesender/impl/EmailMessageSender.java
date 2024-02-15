package com.nhnacademy.edu.springframework.messagesender.messagesender.impl;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.messagesender.MessageSender;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component @Primary
public class EmailMessageSender implements MessageSender {
    public EmailMessageSender(){
        System.out.println("email message created");
    }
    @Override
    public boolean sendMessage(User user, String message) {
        System.out.println("Email Message Sent to "+user.getEmail() + ": "+message);
        return true;
    }
    public void cleanup(){
        System.out.println("email message destroyed");
    }
}
