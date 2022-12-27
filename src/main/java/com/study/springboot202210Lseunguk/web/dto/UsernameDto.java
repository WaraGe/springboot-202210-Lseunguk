package com.study.springboot202210Lseunguk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsernameDto {
    @Pattern (regexp = "^[a-zA-Z\\d]{5,20}$",message = "사용자 ID는 영문, 숫자 조함이여야 하며 5자 이상 20자 이하로 작성하세요")
    private String username;
}
