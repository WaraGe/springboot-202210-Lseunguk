package com.study.springboot202210Lseunguk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.Timer;

@Slf4j
@Aspect
@Component
public class TimerAop {

    @Pointcut("@annotation(com.study.springboot202210Lseunguk.aop.annotation.TimerAspect)")
    public void TimerAspect() {}

    @Around("TimerAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object returnValue = proceedingJoinPoint.proceed();

        stopWatch.stop();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName(); // 클래스 이름 가져오기
        String methodName = proceedingJoinPoint.getSignature().getName(); // Aop가 작동되는 메소드의 이름

        log.info("Class >>{}, Method >>{}: {}초", className, methodName, stopWatch.getTotalTimeSeconds()); // {}괄호의 순서대로 값을 대입
//        log.info("초");
//        log.info("메소드 실행 시간: {}" + stopWatch.getTotalTimeSeconds() + "초");
//        System.out.println("메소드 실행 시간: " + stopWatch.getTotalTimeSeconds() + "초");

        return returnValue;
    }
}
