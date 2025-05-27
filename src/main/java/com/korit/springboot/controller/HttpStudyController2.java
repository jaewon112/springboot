package com.korit.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

// 요청 URL : /api/age 응답 데이터 : { name : 김재원, age :31}
// 요청 URL : /api/names 응답 데이터 : ["김재1","김재2"....]
// 요청 URL : /api/students 응답 데이터 : [{name: 김재원 , age:32}]
// 요청 URL : /api/students 응답 데이터 :
/*
    [
        {
            name: 김재1,
            age: 31,
            hobby : [축구 농구]
        },
        {
            name: 김재1,
            age: 31,
            hobby : [축구 농구]
        },
    ]
 */
@RestController
@RequestMapping("/api")
public class HttpStudyController2 {
    @GetMapping("/age")

    // 새로운 참조주소값 생성가능
    public Map<String, Object> get() {
        Map<String, Object> ob = new HashMap<>();
        ob.put("name", "김재원");
        ob.put("age", 32);
        return ob;
    }

    public Map<String, Object> get2() {
        return Map.of("name", "김재원", "age", 32); // 참조주소값 고정
    }

    @GetMapping("/names")
    public List<String>names() {
        List<String> name =List.of("김재원","김재2","김재3");
        return name;
    }

    public List<String> names2() {
        return List.of("김재원","김재2","김재3");
    }

    public String[] names3() {
        String[] names = {"김재원","김재2","김재3"};
        return names;
    }
    @GetMapping("students")
    public List<Map<String,Object>> students() {
        Map<String, Object> ob1 = new HashMap<>();
        Map<String, Object> ob2 = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        ob1.put("name", "김재1");
        ob1.put("age", 32);
        ob2.put("name", "김재2");
        ob2.put("age", 32);

        list.add(ob1);
        list.add(ob2);

        return list;
    }

    public List<Map<String, Object>> list2 = List.of(Map.of("name", "김재원", "age", 32),
            Map.of("name", "김재원", "age", 32));

    public List<Map<String,Object>> student2() {
        return List.of(Map.of("name", "김재원", "age", 32),
                Map.of("name", "김재원", "age", 32));
    }

    @GetMapping("students2")
    public List<Map<String,Object>> students3() {
        Map<String, Object> ob1 = new HashMap<>();
        Map<String, Object> ob2 = new HashMap<>();
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<Map<String,Object>> list3 = new ArrayList<>();

        list1.add("축구");
        list1.add("농구");
        list2.add("골프");
        list2.add("낚시");

        ob1.put("name", "김재원");
        ob1.put("age",31);
        ob1.put("hobby", list1);
        ob2.put("name", "김재2");
        ob2.put("age",31);
        ob2.put("hobby", list2);
//        ob3.put("hobby", new String[] {"골프","낚시"});   이런식으로도 생성 가능

        // Objects , Arrays -> 클래스 뒤에 s 붙는건 static이란 뜻
        list3.add(ob1);
        list3.add(ob2);

        return list3;

    }
}
