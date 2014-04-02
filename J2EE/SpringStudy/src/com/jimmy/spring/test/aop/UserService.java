package com.jimmy.spring.test.aop;

public class UserService implements IUserService {
    private String user;

    public UserService() {
    }

    public UserService(String user) {
        this.user = user;
    }

    @Override
    public void save() {
        System.out.println("personService.save is invoke!");
    }

    @Override
    public String getUser() {
        return user;
    }

}
