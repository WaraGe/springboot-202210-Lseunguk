package com.study.springboot202210Lseunguk.web.controller.account;

import com.study.springboot202210Lseunguk.service.UserService;
import com.study.springboot202210Lseunguk.web.dto.CMRespDto;
import com.study.springboot202210Lseunguk.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(String username) { //RequestParam을 생략한값
        userService.duplicateUsername(username); // 호출이 가능한 이유는 위에 있는 Autowired때문
        return ResponseEntity.ok().body(new CMRespDto<>("가입이 가능한 아이디 입니다", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입완료", null));
    }
}
