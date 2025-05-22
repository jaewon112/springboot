package com.korit.springboot.controller;

import com.korit.springboot.dto.Address;
import com.korit.springboot.dto.PostData;
import com.korit.springboot.dto.Student;
import com.korit.springboot.dto.Student1;
import com.korit.springboot.dto.param.SearchStudyDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HttpStudyController3 {


    /*
        주소에 값을 입력한다.
        - 파라메터를 통해 값을 입력한다.
            파라미터의 주소는 ? 뒤에 따라오는 key value를 의미함.
            http://localhost:8080/api/~~~~? 파라미터 (여러개의 데이터를 요청시 &로 구분)
            //params 는 Get 요청에서만 사용


            @RequestParam (클래스타입 객체명)
     */
    @GetMapping("/study/get")
    public String get(
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        return "get 요청입니다.";
    }

    /*
        가능한 json으로 값을 입력한다.
        "{
            "key1" : "value1",
            "key2" : "value2",
            "key3" {
                key4: value3,
                key5: ["a","b","c","d","e"]
            },
        }"
        json으로 요청받을 때는 @RequestBody 반드시 입력
     */
    @PostMapping("/study/post")
    public String post(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        System.out.println(data.get("age"));
        System.out.println(data.get("address"));
        Object data2 = data.get("address");
        Map<String, Object> map = (Map<String, Object>) data2;
        Object data3 = map.get("address4");
        List<String> list = (List<String>) data3;

        System.out.println(((Map<String, Object>) data.get("address")).get("address4"));
        return "post 요청입니다.";
    }

    @PostMapping("/study/post2")
    public String post2(@RequestBody PostData postData) {
        System.out.println(postData);
        System.out.println(postData.getAddress());
        Address add = postData.getAddress();
        System.out.println(add.getAddress4());
        return "post2 요청입니다";
    }

    /*
        json으로 값을 입력한다
     */
    @PutMapping("/study/put")
    public String put() {
        return "put 요청입니다";
    }

    /*
        경로에 값을 입력한다.
        /api/study/delete/book/10

     */
    @DeleteMapping("/study/delete/{category}/{id}")
    public String delete(@PathVariable String category,@PathVariable Long id) {
        return "delete 요청입니다";
    }

    @GetMapping("/study/student")
    public List<Student> student1() {
        return List.of(new Student("김재원", 31), new Student("김재2", 31));
    }

    @GetMapping("/study/students")
    public List<Student> getStudents(SearchStudyDto searchStudyDto) {

//        List<Student> students = List.of(
//                new Student("김준일", 32),
//                new Student("김명규", 28),
//                new Student("정선유", 26),
//                new Student("염진우", 30),
//                new Student("이수원", 25)
//        );
//
        System.out.println(searchStudyDto);
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        int startCode = 0xAC00;     // 가
        int endCode = 0xD7A3;       // 힇

        for (int i = 0; i < 1000; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append((char) (startCode + random.nextInt(endCode - startCode + 1)));
            builder.append((char) (startCode + random.nextInt(endCode - startCode + 1)));
            builder.append((char) (startCode + random.nextInt(endCode - startCode + 1)));
            students.add(new Student(builder.toString(), random.nextInt(100) + 1));
        }
        if(searchStudyDto.getPage() < 1) {
            searchStudyDto.setPage(1);
        }
        System.out.println(searchStudyDto);
        /*
            page = 1    ->  0
            page = 2    ->  10
            page = 3    ->  20
         */
        List<Student> foundStudents = students;
        if (searchStudyDto.getSearchValue() != null && !searchStudyDto.getSearchValue().isBlank()) {
            foundStudents = students.stream().filter(s -> s.getName().contains(searchStudyDto.getSearchValue())).collect(Collectors.toList());
        }

        int startIndex = (searchStudyDto.getPage() - 1) * searchStudyDto.getCount();
        List<Student> newStudents = new ArrayList<>();
        for (int i = 0; i < (foundStudents.size() < searchStudyDto.getCount() ? foundStudents.size() : searchStudyDto.getCount()); i++) {
            try {
                newStudents.add(foundStudents.get(startIndex + i));
            } catch (Exception e) {
                break;
            }
        }

        return newStudents;
    }


    @PostMapping("/study/student")
    public Map<String, Object> student2(@RequestBody Student student) {

        return Map.of("status", "성공", "data", student);
    }
}
