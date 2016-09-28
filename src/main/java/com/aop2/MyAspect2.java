package com.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Aspect
@Component(value = "ma3")
public class MyAspect2 {

    @Before(value = "execution(* com.aop2.*.*(..))")
    private void before1(JoinPoint joinPoint){
        System.out.println("before1");
    }

    @AfterReturning(value = "execution(* com.aop2.*.*(..))", returning = "result")
    private int after1(JoinPoint joinPoint, int result){
        System.out.println("after1");
        return result;
    }

    @Around(value = "execution(* com.aop2.*.*(..))")
    private Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("around1");
        Object res = proceedingJoinPoint.proceed();

        return res;
    }

    @AfterReturning(value = "execution(* com.aop2.*.*(..))")
    private void afterThrowing1(){
        System.out.println("afterThrowing1");
    }

    @After(value = "execution(* com.aop2.*.*(..))")
    private void after(){
        System.out.println("after");
    }

}
