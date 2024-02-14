package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.context.annotation.Bean;

public interface MessageSender {
    public void sendMesssage(User user, String message);
}
