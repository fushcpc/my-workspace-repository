package com.jimmy.spring.test.aop.usage.impl;

import com.jimmy.spring.test.aop.usage.IAOPTestService;

public class AOPTestService implements IAOPTestService {
    @Override
    public void save(String username) {
        System.out.println("function save is invoked. username = " + username);
    }
}
