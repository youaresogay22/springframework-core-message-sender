package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
@EnableAspectJAutoProxy
public class MainConfig {
 
}