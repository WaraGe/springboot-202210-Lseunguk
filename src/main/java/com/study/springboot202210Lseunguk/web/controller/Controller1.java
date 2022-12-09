package com.study.springboot202210Lseunguk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Controller1 {

//  사진의 Controller클래스
//    @RequestMapping(value = "/page1", method = RequestMethod.GET);
    @GetMapping("/page1")
    public ModelAndView page1() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("page1"); // file명
        mav.addObject("key", "value"); // 페이지가 열릴때 thymeleaf를 활용해서 데이터를 활용 (key,value를 적을때 대문자 포함하지 않기)
        return mav;
    }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
//      html 파일의 이름만 return 해주면 됨

    }
}
