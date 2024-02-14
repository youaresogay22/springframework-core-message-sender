package com.nhnacademy.edu.springframework.messagesender.impl;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component @Primary
public class EmailMessageSender implements MessageSender {
    public EmailMessageSender(){
        System.out.println("email message created");
    }
    @Override
    public void sendMesssage(User user, String message) {
        System.out.println("Email Message Sent to "+user.getEmail() + ": "+message);
    }
    public void cleanup(){
        System.out.println("email message destroyed");
    }
}
