package com.nhnacademy.edu.springframework.day1;

import com.nhnacademy.edu.springframework.day1.service.BannerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day1_beans.xml")) {

            new BannerService(context.getBean("goodBanner", Banner.class)).doPrint();
            new BannerService(context.getBean("badBanner", Banner.class)).doPrint();

        }
    }
}
