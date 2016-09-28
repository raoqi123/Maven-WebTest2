package com.aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Component(value = "ma4")
@Aspect
public class MyAspect2 {

    @Before(value = "execution(* com.aop3.*.*(..))")
    private void before1(JoinPoint joinPoint){
        System.out.println("before1");
    }

    @AfterReturning(value = "execution(* com.aop3.*.*(..))",returning = "result")
    private void afterReturning1(JoinPoint joinPoint, int result){
        System.out.println("afterReturning1");
    }

    @AfterThrowing(value = "execution(* com.aop3.*.*(..))", throwing = "throwable")
    private void afterThrowing1(JoinPoint joinPoint, Throwable throwable){
        System.out.println("afterThrowing1");
    }

    @After(value = "execution(* com.aop3.*.*(..))")
    private void after1(JoinPoint joinPoint){
        System.out.println("after1");
    }

    @Around(value = "execution(* com.aop3.*.*(..))")
    private Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("around1");
        Object res = proceedingJoinPoint.proceed();

        return res;
    }
}
