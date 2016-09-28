package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Component
public class WomanShow {

    public void print(){
        System.out.println("WomanShow print");
    }

    public int get(){
        System.out.println("get");
        return 1;
    }
}
