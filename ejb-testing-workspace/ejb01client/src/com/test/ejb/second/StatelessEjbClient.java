package com.test.ejb.second;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StatelessEjbClient {
    public static void main(String[] args) throws NamingException {
        //第一次会话
        InitialContext context = new InitialContext();
        StatelessEjb StatelessEjb1 = (StatelessEjb) context.lookup("StatelessEjbBean/remote");
        System.out.println(StatelessEjb1.getResults());
        StatelessEjb1.compute(1);
        System.out.println(StatelessEjb1.getResults());
        StatelessEjb1.compute(1);
        System.out.println(StatelessEjb1.getResults());
        
        System.out.println();
        
        //第二次会话
        StatelessEjb StatelessEjb2 = (StatelessEjb) context.lookup("StatelessEjbBean/remote");
        System.out.println(StatelessEjb2.getResults());
        StatelessEjb2.compute(1);
        System.out.println(StatelessEjb2.getResults());
        StatelessEjb2.compute(1);
        System.out.println(StatelessEjb2.getResults());
        
        System.out.println(StatelessEjb1 == StatelessEjb2);
    }
}
