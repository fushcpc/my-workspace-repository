package com.test.ejb.first;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.test.ejb.first.FirstEjb;

public class FirstEjbClient {
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        FirstEjb ejb = (FirstEjb) context.lookup("FirstEjbBean/remote");
        String something = ejb.saySomething("Jimmy.Chen");
        System.out.println(something);
    }
}
