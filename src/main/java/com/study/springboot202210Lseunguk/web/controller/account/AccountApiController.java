package com.study.springboot202210Lseunguk.web.controller.account;

import com.study.springboot202210Lseunguk.aop.TimerAop;
import com.study.springboot202210Lseunguk.aop.annotation.ParamsAspect;
import com.study.springboot202210Lseunguk.aop.annotation.PrintTestAspect;
import com.study.springboot202210Lseunguk.aop.annotation.TimerAspect;
import com.study.springboot202210Lseunguk.aop.annotation.ValidAspect;
import com.study.springboot202210Lseunguk.service.UserService;
import com.study.springboot202210Lseunguk.web.dto.CMRespDto;
import com.study.springboot202210Lseunguk.web.dto.UserDto;
import com.study.springboot202210Lseunguk.web.dto.UsernameDto;
import com.study.springboot202210Lseunguk.web.exception.CustomValidException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    //simple log Fasade
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);


    @Autowired
    private UserService userService;

    @ParamsAspect
    @TimerAspect
//    @PrintTestAspect
    @ValidAspect
    @GetMapping("/username")
//   정규식의 시작 : ^, 정규식의 끝 : $
//    [a-zA-Z] a-zA-Z라는것은 영숫자만 사용하라는뜻
//    \\역슬레시는 두개여야지만 하나. \\d는 숫자 전체를 뜻함
//    {5,20}은 5자이상 20자 이하을 뜻함
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) { //BindingResult(오류수집)

        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입이 가능한 아이디 입니다", true));
    }

    @PostMapping("/user")
//    @Valid 벨리드 어노테이션이 있어야지 오류를 잡을수있음 (BindingResult를 사용해야함)
        public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) { //json으로 보냈기때문에 RequestBody로 받는것
//        System.out.println(userDto);
//        System.out.println(bindingResult.getFieldErrors());
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입완료", null));
    }
}
