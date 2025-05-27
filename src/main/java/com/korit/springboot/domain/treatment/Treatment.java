package com.korit.springboot.domain.treatment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity     // 1.데이터베이스객체생성(JPA만사용)
@Table(name = "treatment_tb")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에게 위임하는 방식으로
    // id값을 따로 할당하지 않아도 데이터베이스가 AUTO_INCREMENT를 하여 기본키를 생성해준다.
    @Column(name = "treatment_id")
    private Integer id;

    private String treatmentName;
}
