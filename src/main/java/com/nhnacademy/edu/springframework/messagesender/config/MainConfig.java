package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import com.nhnacademy.edu.springframework.messagesender.impl.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.impl.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

@Configuration
@ImportResource("classpath:/beans.xml")
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
public class MainConfig {
//    @Bean @SMS
//    public MessageSender smsMessageSender(){
//        return new SmsMessageSender();
//    }
//    @Bean @Primary
//    public MessageSender emailMessageSender(){
//        return new EmailMessageSender();
//    }
//    @Bean @Autowired @Conditional(MessageSendServiceCondition.class)
//    public MessageSendService messageSendService(MessageSender messageSender){
//        return new MessageSendService(messageSender);
//    }
    public static class MessageSendServiceCondition implements Condition{
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return Objects.requireNonNull(context.getBeanFactory()).containsBean("smsMessageSender");
        }
    }
}