package com.nhnacademy.edu.springframework.messagesender.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("Dooray")
public @interface Dooray {
}
