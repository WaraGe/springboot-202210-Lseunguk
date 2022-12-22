package com.study.springboot202210Lseunguk.repository;

import com.study.springboot202210Lseunguk.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int saveEmp(EmpDto empDto);
    public EmpDto getEmp(int empId);
}
