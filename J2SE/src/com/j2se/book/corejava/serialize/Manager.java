package com.j2se.book.corejava.serialize;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    private Employee secretary;

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return "Manager [" + super.toString() + "secretary=" + secretary + "]";
    }
}
