package com.proxy;



import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by raoqi on 16/9/25.
 */
public class UserDAOFactory2 implements MethodInterceptor {

    private Object target;

    public UserDAOFactory2(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback((Callback) this);

        return enhancer.create();
    }


    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before!");
//        Object res = method.invoke(target, args);
        Object res = methodProxy.invokeSuper(proxy, args);
        System.out.println("After!");

        return res;
    }
}
