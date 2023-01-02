package com.study.springboot202210Lseunguk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ParamsAop {

    @Pointcut("@annotation(com.study.springboot202210Lseunguk.aop.annotation.ParamsAspect)")
    public void ParamsAspect() {}

    @Around("ParamsAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature(); // 매개변수의 이름을 가져오기 위한 다운캐스팅
        String className = codeSignature.getDeclaringTypeName(); // 클래스이름
        String methodName = codeSignature.getName(); // 메소드 이름

        String[] argNames = codeSignature.getParameterNames(); // (CodeSignature)로 다운캐스팅을 해야지만 사용가능함
        Object[] args = proceedingJoinPoint.getArgs(); // ArgsName과 배열은 다르지만 순서대로 값이 들어가므로 밑의 for문에서 출력시 같은 값을 가져옴

        for(int i =0; i< argNames.length; i++) {
            log.info("Params >> {}.{}({}): {}", className, methodName, argNames[i], args[i]);
        }

        Object returnValue = proceedingJoinPoint.proceed();


        return returnValue;
    }
}
