package com.study.springboot202210Lseunguk.repository;

import com.study.springboot202210Lseunguk.web.dto.CategoryDto;
import com.study.springboot202210Lseunguk.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getCategories();
    public int modifyCategory(CategoryDto categoryDto);
}
