package com.nhnacademy.edu.springframework.messagesender.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
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
