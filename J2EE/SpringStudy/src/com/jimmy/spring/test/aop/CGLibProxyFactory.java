package com.jimmy.spring.test.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxyFactory implements MethodInterceptor {//实现MethodInterceptor接口

    private Object targetObject;//代理的目标对象   

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();//该类用于生成代理对象
        enhancer.setSuperclass(this.targetObject.getClass());//设置父类
        enhancer.setCallback(this);//设置回调用对象为本身
        return enhancer.create();
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invoke(this.targetObject, args);
    }

}
