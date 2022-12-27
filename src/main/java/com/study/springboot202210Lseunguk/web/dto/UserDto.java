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
    // (앞에서부터 일치하는것을 찾는다)
    // (?=a) 긍정형 전방탐색 : a가 있어야 쓸수있는것
    // (?!a)  전방탐색 : a가 없어야 쓸수있는것 전방탐색
    // (?=.*) 0개 이상, 밑과 같이 코드를
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*])[a-zA-Z~!@#$^&*\\d]{8,16}$", message = "비밀번호는 영문, 숫자, 특수문자를 포함하여 8~16자로 작성하세요")
    private String password;

    @Pattern(regexp = "^[가-힇]{2,5}$", message = "이름은 한글, 숫자 조합이어야 하며 2자 이상 5자 이하로 작성하세요")
    private String name;

    @NotBlank(message = "이메일 입력해주세요")
    @Email
    private String email;
}
