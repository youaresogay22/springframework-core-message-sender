package com.nhnacademy.edu.springframework.messagesender.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAspect {
    @Pointcut("execution(public boolean com.nhnacademy.edu.springframework.messagesender.messagesender.MessageSender+.sendMessage(..))")
    private void anySendMessage(){}

    @Around("anySendMessage()")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            pjp.proceed();
            stopWatch.start();
            System.out.println("Hello World!");
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
        return null;
    }
}
