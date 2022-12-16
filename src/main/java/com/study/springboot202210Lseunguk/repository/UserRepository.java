package com.study.springboot202210Lseunguk.repository;

import com.study.springboot202210Lseunguk.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserById(int userId);
}
