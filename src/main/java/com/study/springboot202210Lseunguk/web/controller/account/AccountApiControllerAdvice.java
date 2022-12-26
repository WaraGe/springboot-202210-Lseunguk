package com.study.springboot202210Lseunguk.web.controller.account;


import com.study.springboot202210Lseunguk.web.dto.CMRespDto;
import com.study.springboot202210Lseunguk.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //예외처리가 가능한 Controller
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class) // 예외를 catch
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(),e.getErrorMap()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException e) {
        Map<String, String> errorMap = new HashMap<>(); // 어느 코드에 어떤 오류가 났는지 Map에 담는다
        System.out.println(e.getConstraintViolations()); // type : set
        // 자동으로 들어가게 설정하는 방법(오류 메세지를 forEach로 하나씩 열어주기)
        e.getConstraintViolations().forEach(error -> {
            String errorProperty = error.getPropertyPath().toString(); // Path를 문자열로?
            errorProperty = errorProperty.substring(errorProperty.lastIndexOf(".") + 1); // .이후의 문자열
            errorMap.put(errorProperty, error.getMessage());
        });
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(),errorMap));
    }
}
