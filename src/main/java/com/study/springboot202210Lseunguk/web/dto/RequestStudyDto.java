package com.study.springboot202210Lseunguk.web.dto;

import lombok.Data;

//받을시 setter
//응답 gettter
@Data
public class RequestStudyDto {
    private String name;
    private String email;
    private String address;
}
