package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Configuration
@ImportResource("classpath:/beans.xml")
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
@EnableAspectJAutoProxy
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

    @Bean
    public String dbms() {
        String db = new String("DBMS");
        return db;
    }

    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(), "");
    }

    //https://hook.dooray.com/services/3204376758577275363/3738651962004364986/HByzZBRuRu69-EUTsWR0tg
    public static class MessageSendServiceCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return Objects.requireNonNull(context.getBeanFactory()).containsBean("smsMessageSender");
        }
    }
}