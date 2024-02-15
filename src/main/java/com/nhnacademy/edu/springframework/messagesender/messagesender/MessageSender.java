package com.nhnacademy.edu.springframework.messagesender.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.context.annotation.Bean;

public interface MessageSender {
    public void sendMessage(User user, String message);
}
