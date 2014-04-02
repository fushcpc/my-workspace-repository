package com.jimmy.sourceinsignt.aop.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

    private Object target;

    public DynamicInvocationHandler(Object obj) {
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("before invoke " + method);
        Object result = method.invoke(target, args);
        System.out.println(args == null);
        System.out.println("after invoke " + method);
        return result;
    }

}
