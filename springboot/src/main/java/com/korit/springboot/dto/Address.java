package com.korit.springboot.dto;

import lombok.Data;

import java.util.List;

@Data

public class Address {
    private String address1;
    private String address2;
    private String address3;
    private List<String> address4;
}

 /*
    Class Student{name,age}
        get 요청
        /api/study/students
        응답 : [{Student객체1},{Student객체2}],{Student객체3}]
        post 요청
        /api/students
        응답 : {status:"성공",data : {Student객체}}
     */