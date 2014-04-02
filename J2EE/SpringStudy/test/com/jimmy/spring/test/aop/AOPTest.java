package com.jimmy.spring.test.aop;

import org.junit.Test;

public class AOPTest {

    @Test
    public void testOK() {
        JDKProxyFactory factory = new JDKProxyFactory();
        IUserService service = (IUserService) factory.createProxyInstance(new UserService("HelloKitty"));
        service.save();//actually invoke
    }

    @Test
    public void testFailed() {
        JDKProxyFactory factory = new JDKProxyFactory();
        IUserService service = (IUserService) factory.createProxyInstance(new UserService());
        service.save();//didn't invoke
    }
}
