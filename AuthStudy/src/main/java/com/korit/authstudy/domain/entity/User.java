package com.korit.authstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
                                        // @RequiredArgsConstructor는 final이나 @NonNull으로 선언된 필드만을 파라미터로 받는 생성자를 자동으로 생성
@Data // @ToString, @Getter, @Setter, @EqualsAndHashCode, @RequiredArgsConstructor 를 자동 생성해줌
@Builder
@NoArgsConstructor // 기본생성자 자동생성
@AllArgsConstructor // 지역변수들의 매개변수 생성자 모두 생성해줌
@Entity
@Table(name = "users_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Integer id;

    private String username;
    private String password;
    private String fullName;
    private String email;
}
