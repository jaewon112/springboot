package com.korit.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
    HttpServletRequst 객체란?
    외부에서 TomCat 웹 서버로 요청시 생성되는 요청정보객체이다.

 */
@RestController
public class HttpServletRequestController {

    //PSA 개념에 관한 코드
    @GetMapping("/api/name2")
    public String getName2(@RequestParam(required = false) String a , @RequestParam(required = false) Integer b){

        return "김재원";
    }
}
