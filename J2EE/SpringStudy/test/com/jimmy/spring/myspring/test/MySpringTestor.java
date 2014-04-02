package com.jimmy.spring.myspring.test;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jimmy.spring.test.service.PersonService;

public class MySpringTestor {
    private static ApplicationContext contex = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        contex = new ClassPathXmlApplicationContext("bean.xml");
    }

    @Test
    public void initBeanTest() {
        PersonService personService = (PersonService) contex.getBean("personService");
        personService.save();
    }

    @Test
    public void initStaticFactoryBeanTest() {
        PersonService personService = (PersonService) contex.getBean("staticFactoryPersonService");
        personService.save();
    }

    @Test
    public void initFactoryBeanTest() {
        PersonService personService = (PersonService) contex.getBean("factoryPersonService");
        personService.save();
    }

    @Test
    public void singleBean() {
        PersonService personService1 = (PersonService) contex.getBean("personServiceSingleton");
        PersonService personService2 = (PersonService) contex.getBean("personServiceSingleton");
        Assert.assertTrue(personService1 == personService2);
    }

    @Test
    public void prototypeBean() {
        PersonService personService1 = (PersonService) contex.getBean("personServicePrototype");
        PersonService personService2 = (PersonService) contex.getBean("personServicePrototype");
        Assert.assertTrue(personService1 != personService2);
    }

}
