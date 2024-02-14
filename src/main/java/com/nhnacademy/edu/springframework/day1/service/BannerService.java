package com.nhnacademy.edu.springframework.day1.service;

import com.nhnacademy.edu.springframework.day1.Banner;

public class BannerService {
    private final Banner banner;

    public BannerService(Banner banner) {
        this.banner = banner;
    }

    public void doPrint(){
        banner.print();
    }
}
