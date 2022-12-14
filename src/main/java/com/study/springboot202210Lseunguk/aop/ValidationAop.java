package com.study.springboot202210Lseunguk.aop;

import com.study.springboot202210Lseunguk.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {
    //                   *은 모든 자료형을 반환   경로 이후에 있는 모든 클래스 파일의 매개변수가 하나라도 있는 모든 매개변수의 메소드를 가져옴
    @Pointcut("execution(* com.study.springboot202210Lseunguk.web.controller.account.AccountApiController.*(..))")
    //ex) @Pointcut("execution(* com.study.springboot202210Lseunguk.web.controller..*.*(..))") controller의 하위 모든 클래스의 모든 메소드를 허용한다
    private void executionPointCut() {}

    @Pointcut("@annotation(com.study.springboot202210Lseunguk.aop.annotation.ValidAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()") // 값 비교를 전, 후 둘다 한다
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
                                            //proceedingJoinPoint의 메소드 정보들이 들어가
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg);
        }

        System.out.println("AOP 작동");

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg; // down casting
                break;
            }
        }

        if(bindingResult != null) {
            if(bindingResult.hasErrors()) { // error가 있으면 Map에 담기
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }
        
        //↑ 메소드가 호출 전처리
        Object returnValue = proceedingJoinPoint.proceed(); // proceed는 실행된 메소드
        //↓ 메소드가 호출 후처리
//        return proceedingJoinPoint.proceed(); // 빨간줄뜨면 예외처리 alt enter
        return returnValue;
    }
}
