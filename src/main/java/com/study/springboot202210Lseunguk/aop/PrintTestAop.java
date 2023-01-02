package com.study.springboot202210Lseunguk.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

@Aspect
@Component
public class PrintTestAop {

    @Pointcut("@annotation(com.study.springboot202210Lseunguk.aop.annotation.PrintTestAspect")
    private void printPointcut() {}

    @Around("printPointcut()")
    public void print(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg.toString());
        }

    }
}
