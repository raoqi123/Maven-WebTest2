package com.rq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by raoqi on 16/9/25.
 */
@Scope("prototype")
@Component("person")
public class Person {
    @Value("戴佳鑫111")
    private String name;
    @Value("19")
    private int age;
    @Resource(name="book")
    private Book book;

    @PostConstruct
    private void init(){
        System.out.println("Person init!");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Person destroy!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", book=" + book +
                '}';
    }
}
