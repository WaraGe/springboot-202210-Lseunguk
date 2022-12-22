package com.study.springboot202210Lseunguk.service;

import com.study.springboot202210Lseunguk.repository.EmployeeRepository;
import com.study.springboot202210Lseunguk.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmpDto empDto) {
        return employeeRepository.saveEmp(empDto) > 0 ? empDto.getEmpId() : 0;
    }
    public EmpDto getId(int empId) {
        EmpDto empDto = null;
        empDto = employeeRepository.getEmp(empId);
        return empDto;
    }
}
