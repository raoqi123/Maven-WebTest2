package com.aop3;

import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Component(value = "target2")
public class Target {
    public int get(int x){
        System.out.println("get:"+x);
        return x;
    }
}
