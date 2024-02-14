package com.nhnacademy.edu.springframework.day1.impl;

import com.nhnacademy.edu.springframework.day1.Banner;

public class GoodBanner  implements Banner {
    @Override
    public void print() {
        System.out.println("good");
    }
}
