package com.study.springboot202210Lseunguk.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {

    @Autowired // Controller가 생성될때 @Autowired가 붙어 있다면 ioc컨테이너를 자동으로 주입
    @Qualifier("usi3") // @Component가 여러개 있을때 사용

//    private UserServiceImpl2 userService;
    private UserService userService;


    @ResponseBody
    @GetMapping("/ioc")
    public String IocTest() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}
