package com.korit.springboot.ioc;

import org.springframework.stereotype.Component;

public class 엘지배터리 implements 배터리 {

    @Override
    public void 전류공급() {
        System.out.println("엘지배터리 전류 공급");
    }

    @Override
    public void 충전() {
        System.out.println("엘지배터리 충전");

    }
}
