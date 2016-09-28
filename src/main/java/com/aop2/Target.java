package com.aop2;

import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Component(value = "target1")
public class Target {
    public int get(int x){
        System.out.println("get:"+x);
        return x;
    }
}
