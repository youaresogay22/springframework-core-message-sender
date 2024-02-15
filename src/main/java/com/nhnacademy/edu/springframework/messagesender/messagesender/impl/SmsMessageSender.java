package com.nhnacademy.edu.springframework.messagesender.messagesender.impl;

import com.nhnacademy.edu.springframework.messagesender.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.stereotype.Component;
@Component @SMS
public class SmsMessageSender implements MessageSender {
    public SmsMessageSender(){
        System.out.println("sms message created");
    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to " +user.getPhoneNumber() + ": "+message);
    }

    public void init(){
        System.out.println("sms message initiated");
    }
}
