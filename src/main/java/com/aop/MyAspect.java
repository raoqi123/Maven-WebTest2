package com.aop;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Aspect
@Component
public class MyAspect {

    @Before(value = "execution(* com.aop.*.*())" )
    public void before1(JoinPoint joinPoint){
        System.out.println("before1");
    }

    @AfterReturning(value = "execution(* com.aop.*.*())", returning = "resultVal")
    public void after1(JoinPoint joinPoint, Object resultVal){
        System.out.println("after1");
    }

    @Around(value = "execution(* com.aop.*.*())")
    public Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println("执行时间:"+(end-begin) );

        return result;
    }

    @AfterThrowing(value = "execution(* com.aop.*.*())", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("afterThrowing!");
    }
}
