package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("user@red.ussr", "010-1111-1111");
        String message = "안녕하세요";

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.messagesender")) {

            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
            service.doSendMessage(user, message);

        }
    }
}
