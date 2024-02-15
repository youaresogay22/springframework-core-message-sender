package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

    public static void main(String[] args) {
        User user = new User("user@red.ussr", "010-1111-1111");
        String message = "안녕";

        User user2 = new User("user2@blue.us", "010-2222-2222");


        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.messagesender")) {

            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
            service.doSendMessage(user, message);
            service.doSendMessage(user2, message);

//            Object a = context.getBean("dbms");
//            System.out.println(a.getClass());
        }

    }
}
