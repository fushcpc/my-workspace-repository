package com.jimmy.spring.test.aop.usage.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jimmy.spring.test.aop.usage.IAOPTestService;

public class AOPTestServiceTest {

    private ApplicationContext ctx;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("AOP.xml");
    }

    @Test
    public void test() {
        IAOPTestService service = (IAOPTestService) ctx.getBean("aopTestService");
        service.save("david");
    }

}
