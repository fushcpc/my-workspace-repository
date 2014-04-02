package com.jimmy.spring.test.service.factory;

import com.jimmy.spring.test.service.PersonService;
import com.jimmy.spring.test.service.impl.PersonServiceImpl;

public class PersonServiceFactory {
    public static PersonService createOrder() {
        return new PersonServiceImpl();
    }

    public PersonService createOtherOrder() {
        return new PersonServiceImpl();
    }
}
