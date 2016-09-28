package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by raoqi on 16/9/25.
 */
public class UserDAOFactory {

    public static Object getProxyInstance(final Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("为什么乱码");

                        Object res = method.invoke(target,args);
                        System.out.println("123123");

                        return res;
                    }
                });
    }

}
