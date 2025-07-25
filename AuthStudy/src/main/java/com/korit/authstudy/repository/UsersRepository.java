package com.korit.authstudy.repository;

import com.korit.authstudy.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);

    // JPQL
    @Query(value = """ 
        update User
        set fullName = :#{#user.fullName}, email = :#{#user.email}
        where id = :#{#user.id}
        """)
    @Modifying(clearAutomatically = true) // 버퍼를 자동으로 비워줌 (플러쉬한다)
    int updateFullNameOrEmailById(@Param("user") User user);
}
