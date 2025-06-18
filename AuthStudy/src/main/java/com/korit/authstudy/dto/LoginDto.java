package com.korit.authstudy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data
public class LoginDto {

    private String username;
    private String password;
}
