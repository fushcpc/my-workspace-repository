package com.jimmy.spring.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory implements InvocationHandler {
    private Object targetObj;//代理的目标对象

    public Object createProxyInstance(Object obj) {
        this.targetObj = obj;
        /*
         * 第一个参数设置代码使用的类装载器,一般采用跟目标类相同的类装载器 第二个参数设置代理类实现的接口
         * 第三个参数设置回调对象,当代理对象的方法被调用时,会委派给该参数指定对象的invoke方法
         */
        return Proxy.newProxyInstance(this.targetObj.getClass().getClassLoader(), this.targetObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        IUserService service = (IUserService) targetObj;
        if (service.getUser() != null) {
            method.invoke(this.targetObj, args);
        }
        return null;
    }
}
