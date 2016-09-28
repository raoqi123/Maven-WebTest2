package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/28.
 */
@Component
public class ManDAOImpl implements ManDAO {

    public void show() {
        System.out.println("show!!!");
    }
}
