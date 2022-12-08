package com.study.springboot202210Lseunguk.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Configuration에서 Bean을 등록하는 방법
public class TestConfig {



    @Bean
    public Test1 t1() {
        return new Test1();
    }

    @Bean
    public Test2 t2() {
        return new Test2();
    }
}
