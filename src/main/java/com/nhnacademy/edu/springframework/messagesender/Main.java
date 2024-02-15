package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        User user = new User("user@red.ussr","010-1111-1111");
        String message = "안녕";

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
            service.doSendMessage(user,message);

        }
    }
}


//IOC 실습
//            MessageSender emailMessageSender = context.getBean("emailMessageSender", MessageSender.class);
//            MessageSender smsMessageSender = context.getBean("smsMessageSender", MessageSender.class);
//
//            emailMessageSender.sendMesssage(user, message);
//            smsMessageSender.sendMesssage(user, message);
// IOC 실습
//            System.out.println("----------");
//            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class), user,message).doSendMessage();
//            System.out.println("----------");
//            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class), user,message).doSendMessage();
//            System.out.println("----------");
//            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class), user,message).doSendMessage();
//            System.out.println("----------");
//            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class), user,message).doSendMessage();
//            System.out.println("----------");