package com.nhnacademy.edu.springframework.messagesender.aspect;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

public class LoggingAspect {
    @Pointcut("execution(public boolean com.nhnacademy.edu.springframework.messagesender.messagesender.MessageSender.sendMessage(..))")
    private void anySendMessage() {
    }

    @Component
    @Aspect
    @Order(0)
    public static class timeLogger {
        @Around("anySendMessage()")
        public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
            StopWatch stopWatch = new StopWatch("sendWatch");

            stopWatch.start();
            Object result = pjp.proceed();
            stopWatch.stop();

            System.out.println(stopWatch.prettyPrint());

            return result;
        }
    }

    @Component
    @Aspect
    @Order(2)
    public static class parameterLogger {
        @Around("anySendMessage() && args(user, ..)")
        public Object logParameter(ProceedingJoinPoint pjp, User user) throws Throwable {
            Object result = pjp.proceed();

            System.out.println(user);

            return result;
        }
    }
}
