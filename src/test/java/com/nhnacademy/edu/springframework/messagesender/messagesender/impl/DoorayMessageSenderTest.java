package com.nhnacademy.edu.springframework.messagesender.messagesender.impl;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.messagesender.MessageSender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.BeforeTest;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MainConfig.class})
public class DoorayMessageSenderTest {
    @Mock
    private DoorayHookSender doorayHookSender;
    @Mock
    private User user;
    @InjectMocks
    @Autowired
    private MessageSender doorayMessageSender;

    @BeforeTest
    void setup() {
        MockitoAnnotations.initMocks(this);
        when(doorayMessageSender.sendMessage(any(), any())).thenReturn(true);
    }

    @org.junit.Test
    public void testDoorayMessageSender() {
        boolean actual = new DoorayMessageSender(doorayHookSender).sendMessage(user, "안녕하세요");
        Assertions.assertThat(actual).isEqualTo(true);
    }
}
