package com.test.ejb.second;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StatefullEjbClient {
    public static void main(String[] args) throws NamingException {
        //第一次会话
        InitialContext context = new InitialContext();
        StatefullEjb statefullEjb1 = (StatefullEjb) context.lookup("StatefullEjbBean/remote");
        System.out.println(statefullEjb1.getResults());
        statefullEjb1.compute(1);
        System.out.println(statefullEjb1.getResults());
        statefullEjb1.compute(1);
        System.out.println(statefullEjb1.getResults());
        
        System.out.println();
        
        //第二次会话
        StatefullEjb statefullEjb2 = (StatefullEjb) context.lookup("StatefullEjbBean/remote");
        System.out.println(statefullEjb2.getResults());
        statefullEjb2.compute(1);
        System.out.println(statefullEjb2.getResults());
        statefullEjb2.compute(1);
        System.out.println(statefullEjb2.getResults());
        
        System.out.println(statefullEjb1 == statefullEjb2);
    }
}
