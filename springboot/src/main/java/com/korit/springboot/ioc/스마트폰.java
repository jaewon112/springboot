package com.korit.springboot.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
    Component 종류
    1. @Component       -> 특정 기능이 정해져있지않은 객체(나머지객체) filter , converter,exception
    2. @Controller      -> HTTP 요청 및 응답을 처리하는 객체
    3. @Service         -> 비즈니스 로직 또는 메인로직을 정의하고 처리하는 객체
    4. @Repository      -> DataBase와 관련된 로직을 정의하고 처리하는 객체
    5. @Configuration   -> 설정 로직을 정의하고 처리하는 객체 또는 직접생성 후 IOC 등록을 필요로하는 Bean설정
 */
@Component
public class 스마트폰 {

    @Autowired
    private 삼성배터리 b;

    public void 전원켜기() {
        b.전류공급();
        System.out.println("배터리로부터 전류를 공급받아 전원을 켭니다");
    }

}
