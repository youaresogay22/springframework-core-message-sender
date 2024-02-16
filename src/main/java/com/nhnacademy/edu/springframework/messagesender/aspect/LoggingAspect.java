package com.nhnacademy.edu.springframework.messagesender.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAspect {
    @Pointcut("@annotation(com.nhnacademy.edu.springframework.messagesender.annotation.Dooray)")
    private void annotationDooray() {
    }

    @Around("annotationDooray()")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = pjp.proceed();
        stopWatch.stop();

        System.out.println(pjp.getSignature().getDeclaringTypeName() +
                "." + pjp.getSignature().getName() +
                " " + stopWatch.getTotalTimeMillis() + "ms");

        return result;
    }
}
