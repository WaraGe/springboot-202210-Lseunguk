package com.study.springboot202210Lseunguk.web.controller;



import com.study.springboot202210Lseunguk.service.EmployeeService;
import com.study.springboot202210Lseunguk.web.dto.CMRespDto;
import com.study.springboot202210Lseunguk.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmpDto empDto) {
        int emp = employeeService.addEmployee(empDto);
        return ResponseEntity.status(201).body((new CMRespDto<>(emp+"번 직원등록완료",empDto)));
    }
    @GetMapping("api/emp/{empId}")
    public ResponseEntity<?> getEmployId(@PathVariable int empId) { //
        EmpDto empDto = employeeService.getId(empId);
        return ResponseEntity.ok().body(employeeService.getId(empId));
    }
}
