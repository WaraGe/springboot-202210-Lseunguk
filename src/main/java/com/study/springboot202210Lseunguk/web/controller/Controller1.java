package com.study.springboot202210Lseunguk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controller1 {

//  사진의 Controller클래스
//    @RequestMapping(value = "/page1", method = RequestMethod.GET);
    @GetMapping("/page1")
    public String page1() {
        return "page1";
//      html 파일의 이름만 return 해주면 됨
    }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
//      html 파일의 이름만 return 해주면 됨

    }
}
