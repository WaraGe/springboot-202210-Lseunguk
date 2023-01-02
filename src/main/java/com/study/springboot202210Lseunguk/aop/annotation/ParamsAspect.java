package com.study.springboot202210Lseunguk.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Runtime시점에 사용을 하기 위하여 작성
@Target({ElementType.TYPE, ElementType.METHOD}) // class,  method위에다가 작성이 가능하게 만들기 위하여 작성
public @interface ParamsAspect {

}
