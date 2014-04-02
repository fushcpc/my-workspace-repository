package com.jimmy.sourceinsignt.aop.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicInvocationHandler(realSubject);
        Subject proxy = (Subject) Proxy.newProxyInstance(realSubject.getClass()
                .getClassLoader(), realSubject.getClass().getInterfaces(),
                handler);
        proxy.request();
        System.out.println(proxy.getClass());
        System.out.println("*****************************");
        System.out.println(proxy);
    }
}
