package com.jimmy.spring.test.aop.usage;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAOPInterceptor {
    @Pointcut("execution (* com.jimmy.spring.test.aop.usage.impl..*.*(..))")
    public void anyMethod() {
        System.out.println("anyMethod is invoke.....Pointcut");
    }

    @Before("anyMethod() && args(username)")
    public void doBefore(String username) {
        System.out.println("前置通知.....Before, 传入的参数是:" + username);
    }

    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知.....AfterReturning");
    }

}
