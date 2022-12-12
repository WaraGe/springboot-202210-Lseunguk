package com.study.springboot202210Lseunguk.web.controller;

import com.study.springboot202210Lseunguk.web.dto.RequestStudyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Objects;

@Controller
public class ControllerStudy {

    @GetMapping("/study/page")
    public String 페이지응답() {
        return "page_study"; // 파일명 입력 html을 띄워줌
    }

    @ResponseBody
    @GetMapping("/study/text/1")
    public String 문자열데이터응답() {
        return "문자열 응답"; // 문자열 입력 문자열을 띄워줌
    }

    @ResponseBody
    @GetMapping("/study/text/2")
    public String 요청데이터Params(String data1, int data2) {
        return "문자열: " + data1 + ", " + "숫자: " + data2;
    }

    @ResponseBody
    @GetMapping("/study/text/3")
    public String 요청데이터Obj(RequestStudyDto requestStudyDto) {
        return requestStudyDto.toString();
    }

    @ResponseBody
    @PostMapping("/study/student/1") //-> page_study에서 ajax로 데이터를 가져오는 방법
    public String getJsonAjax(@RequestBody RequestStudyDto requestStudyDto) {
        return requestStudyDto.toString();
    }

    @ResponseBody
    @GetMapping("/study/student/2") //-> ajax로 json을 응답하는 방법
    public ResponseEntity<?> getJsonAjax2() { //<?> wildcard 어떤 자료형을 리턴해도 좋다
        RequestStudyDto requestStudyDto = new RequestStudyDto();
        requestStudyDto.setName("aaa");
        requestStudyDto.setEmail("aaa@naver.com");
        requestStudyDto.setAddress("부산 진구 가야동");
        return new ResponseEntity<>(requestStudyDto, HttpStatus.OK);
    }
}
