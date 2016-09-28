package com.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by raoqi on 16/9/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AspectTest {

    @Resource
    private ManDAO manDAO;

    @Resource
    private WomanShow womanShow;

    @Test
    public void test(){

        womanShow.get();


        System.out.println("测试完毕");
    }


}
