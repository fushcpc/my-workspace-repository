package com.test.ejb.third;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(UserManagerRemoteEjb.class)
@Local(UserManagerLocalEjb.class)
public class UserManagerEjbImpl implements UserManagerRemoteEjb {

    @Override
    public void addUser(User user) {
        user.setId(10);
        user.setUsername(user.getUsername() + "321");
        System.out.println("user has been changed!" + user);
    }

}
