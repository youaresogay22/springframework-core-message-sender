package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ImportResource("classpath:/beans.xml")
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
@EnableAspectJAutoProxy
public class MainConfig {
    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3204376758577275363/3738651962004364986/HByzZBRuRu69-EUTsWR0tg");
    }

}