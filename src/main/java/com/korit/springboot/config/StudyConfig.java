package com.korit.springboot.config;

import com.korit.springboot.ioc.BeanStudy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class StudyConfig {

    @Bean
    public BeanStudy beanStudy() {
        System.out.println("bean 생성");
        return new BeanStudy();
    }

//    @Bean
//    public Criteria criteria() {
//        return new Criteria();      //외부 객체를 Bean으로 적용하고싶을때 생성해서 @Bean적용
//    }

}
