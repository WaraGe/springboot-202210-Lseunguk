package com.study.springboot202210Lseunguk.web.controller;

import com.study.springboot202210Lseunguk.web.dto.CMRespDto;
import com.study.springboot202210Lseunguk.web.dto.UserDto;
import com.study.springboot202210Lseunguk.web.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str") //URL주소에는 대문자를 표기하지 않는다(문자열을 구분할시 하이픈으로 대체한다)
    public String getUserDtoStr() { //ResponseBody와 String이 만나면 text/plain
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }

    @GetMapping("/api/test/user-dto/obj") //URL주소에는 대문자를 표기하지 않는다(문자열을 구분할시 하이픈으로 대체한다)
    public UserDto getUserDtoObj() { //ResponseBody와 객체와 만나면 JSON UserDto대신에 Object를 사용한 이유는 (최상위)라서
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto;
    }

    @GetMapping("/api/test/user-dto/obj1")
    public UserDto getUserDtoObj1(HttpServletResponse response) {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        response.setStatus(400);
        return userDto;
    }

    @GetMapping("/api/test/user-dto/obj2") //ResponseEntity로 감싸면 위 코드처럼 HttpServletResponse를 가져올 필요가 없음
    public ResponseEntity<UserDto> getUserDtoObj2() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
//        return new ResponseEntity(userDto,null,400);
//        return new ResponseEntity<UserDto>(userDto, HttpStatus.BAD_REQUEST); // 400 error
        return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
    }

    @GetMapping("/api/test/user-dto/obj3") // ResponseEntity로 감싸고 와일드카드로 감싸준다면, 리턴자료형 첫번째 칸을 매번 바꿀필요가 없다.
    public ResponseEntity<?> getUserDtoObj3() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
//        return new ResponseEntity<>("1000", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/api/test/user-dto/obj4") // 직관적인 방법 builder 패턴으로 확인
    public ResponseEntity<?> getUserDtoObj4() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
//        return ResponseEntity.ok().body("들어갈 데이터");
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("들어갈 데이터"); //지원하지 않는것들은 status로 적어주면 된다
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto);
    }

    @GetMapping("/api/test/user-dto/obj5") // header에도 값을 지정해서 넣는 방법
    public ResponseEntity<?> getUserDtoObj5() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("HeaderTest", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(userDto); // 이런식으로도 작성이 가능함
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto() {
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", userDto)); //CMRespDto의 값 message, data(공통 응답 객체) CM = 커밋 메세지(Git을 생각)
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        if(userDto.getUsername().isBlank()) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        //임시로 만듦
        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공" , userDto));
    }
}
