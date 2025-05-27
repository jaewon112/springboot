package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HttpStudyController1 {

    @GetMapping("/http")
    public String get() {
        return "";
    }

    @GetMapping("/name")
    public String getName(HttpServletRequest requst) {
        System.out.println(requst.getParameter("address"));
        return "김재원";
    }


}
