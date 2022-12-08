package com.study.springboot202210Lseunguk.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {

    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번: " + student.getStudentId() + "\n이름: "+ student.getStudentName());
    }
}
