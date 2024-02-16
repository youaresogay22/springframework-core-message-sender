package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("user@red.ussr", "010-1111-1111");
        String message = "안녕하세요";

        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("beans.xml")) {

            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
            service.doSendMessage(user, message);

        }
    }
}
