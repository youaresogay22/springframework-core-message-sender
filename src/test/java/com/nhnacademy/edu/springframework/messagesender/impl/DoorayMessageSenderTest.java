package com.nhnacademy.edu.springframework.messagesender.impl;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DoorayMessageSenderTest {
    DoorayHookSender testDoorayHookSender = Mockito.mock(DoorayHookSender.class);
    User testUser = new User("${test email}", "${test phone number}");
    String testMessage = "test message";

    MessageSendService messageSendService = new MessageSendService(new DoorayMessageSender(testDoorayHookSender));

    @Test
    void doorayMessageSenderTest() {
        boolean actual = messageSendService.doSendMessage(testUser, testMessage);
        Assertions.assertThat(actual).isEqualTo(true);
    }
}