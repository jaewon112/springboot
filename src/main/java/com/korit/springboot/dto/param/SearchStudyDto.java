package com.korit.springboot.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class SearchStudyDto {
    private String searchValue;
    private Integer page = 1 ;
    private Integer count = 10;
}
