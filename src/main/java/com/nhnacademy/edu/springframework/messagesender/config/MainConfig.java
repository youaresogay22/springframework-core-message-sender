package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ImportResource("classpath:/beans.xml")
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
public class MainConfig {
    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(), "${hookUrl}");
    }

}