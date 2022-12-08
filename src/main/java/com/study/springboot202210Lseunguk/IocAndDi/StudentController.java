package com.study.springboot202210Lseunguk.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudentController {
    //      이친구가 생성을 함

    @Autowired()
    private StudentService studentService;

    @Autowired
    private Test1 test1;

    @Autowired
    private Test2 test2;

    @Autowired
    private Test2 test;

    @ResponseBody
    @GetMapping("/student")
    public String printStudentInfo() {
        Student student = Student.builder()
                .studentId(2001)
                .studentName("김경민")
                .build();

        test1.print();
        test2.print();
        test.print();

        studentService.printStudentInfo(student);

        return null;
    }
}
