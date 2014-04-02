package com.j2se.annotation.first;

public class UseCaseTest {
    @UseCase(id = 10, description = "passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w\\d\\w*");
    }

    @UseCase(id = 11)
    //it's OK that only provide id without description because there is default value for description
    //if there isn't, this will cause compile error
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
