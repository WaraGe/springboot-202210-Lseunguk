package com.study.springboot202210Lseunguk.service;

import com.study.springboot202210Lseunguk.repository.UserRepository;
import com.study.springboot202210Lseunguk.web.dto.UserDto;
import com.study.springboot202210Lseunguk.web.exception.CustomDuplicateUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDto userDto) {
        int userId = 0;
        userRepository.saveUser(userDto);
        return userDto.getUserId();
    }
    public UserDto getUser(int userId) {
        UserDto userDto = null;
        userDto = userRepository.findUserById(userId);
        return userDto;
    }

    public void duplicateUsername(String username) {
        UserDto userDto = userRepository.findUserByUsername(username); // 아이디를 찾지 못한다면 null값 리턴 == 가입이 가능함
        if(userDto != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("duplicate", "이미 존재하는 사용자 이름입니다"); // key, value값을 전달해야 하기때문에 앞의값은 duplicate
            throw new CustomDuplicateUsernameException("Duplicate username!!", errorMap); // (에러 메시지, errorMap도 생성)
        }
    }
}
