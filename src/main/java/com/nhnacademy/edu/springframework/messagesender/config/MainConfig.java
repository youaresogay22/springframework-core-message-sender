package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.aspect.LoggingAspect;
import com.nhnacademy.edu.springframework.messagesender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
public class MainConfig {
    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3204376758577275363/3738651962004364986/HByzZBRuRu69-EUTsWR0tg");
    }

    @Bean
    public MessageSender doorayMessageSender() {
        return new DoorayMessageSender(doorayHookSender());
    }

    @Bean
    public MessageSendService messageSendService() {
        return new MessageSendService(doorayMessageSender());
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}