package com.study.springboot202210Lseunguk.web.controller;

import com.study.springboot202210Lseunguk.service.UserService;
import com.study.springboot202210Lseunguk.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
//일반 컨트롤러는 html 응답할때
//restcontroller 데이터만 응답할때
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) { //@RequestBody로 받으면 JSON형식으로 요청이 들어감
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
//        return new ResponseEntity<>("데이터", HttpStatus.OK);
        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto); //builder형식
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }

}
