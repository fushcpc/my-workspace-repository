package com.test.ejb.first;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class FirstEjbBean implements FirstEjb {

    @Override
    public String saySomething(String name) {
        return "Hello, " + name;
    }

}
