package com.korit.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST API(RESful API)
 * REST - http 메서드를 올바르게 사용하기위해 만든 설계 원칙
 * RESful API - 설계원칙을 잘 지키며 설계된 API
 * 요청과 응답
 * https://m.blog.naver.com/codingbarbie/223233477242
 * https://hahahoho5915.tistory.com/54
 *
 * 파일 확장자는 URI에 포함하지 않는다. 에 대한 해석
 * http://example.com/api/220/photohttp://example.com/api/220/photo.jpg 라는 jpg형태의 파일을 포함하면 이 파일을 가져온다라는 뜻 고로 이 형태는 사용하지않음
 * https://example.com/api/220/photo 를 사용하여 photo 폴더의 클래스를 가져온다라는 개념
 * Stateless(무상태) - ex) 햄버거 단품을 세트로 변경신청해도 단품과 세트를 같이받는개념 즉 , 전에 했던 행동을 기억하지않는 상태를 무상태라고 칭함
 * Cacheable(캐시 처리 가능) - 자주 쓰는 기능을 저장하는것
 * */
@RestController
public class HttpStudyController4 {

    @GetMapping("/api/study/http/get")
    public ResponseEntity<Map<String, Object>> get() {
//        return new ResponseEntity<>(Map.of("name", "김재원", "age", 32), HttpStatus.BAD_REQUEST); 밑의 리턴과 같은 코드
         return ResponseEntity.badRequest().body(Map.of("name", "김재원", "age", 32));
    }
}
