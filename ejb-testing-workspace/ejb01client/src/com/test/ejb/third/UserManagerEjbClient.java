package com.test.ejb.third;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UserManagerEjbClient {
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        UserManagerRemoteEjb userManager = (UserManagerRemoteEjb) context.lookup("UserManagerEjbImpl/local");
        User user = new User("Jimmy", "Password");
        userManager.addUser(user);
        System.out.println("The user is" + user + " after added from remote server.");
    }
}
