package com.korit.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
}

