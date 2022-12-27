package com.study.springboot202210Lseunguk.web.exception;


import lombok.Getter;

import java.util.Map;

public class CustomValidException extends RuntimeException { // Exception을 사용하면 안되고 RuntimeException을 사용해야함
    @Getter
    private Map<String, String> errorMap;

    public CustomValidException(Map<String, String> errorMap) {
        super("Failed Validation!!!");
        this.errorMap = errorMap;
    }
}
