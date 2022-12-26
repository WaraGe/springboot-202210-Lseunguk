package com.study.springboot202210Lseunguk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    @Pattern(regexp = "^[a-zA-Z\\d]{5,20}$", message = "사용자 ID는 영문, 숫자 조합이어야 하며 5자 이상 20자 이하로 작성하세요")
    private String username;

    private String password;
    @Pattern(regexp = "^[가-힇]{2,5}$", message = "이름은 영문, 숫자 조합이어야 하며 2자 이상 5자 이하로 작성하세요")
    private String name;
    @NotBlank(message = "이메일 입력해주세요")
    @Email
    private String email;
}
