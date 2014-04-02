package com.j2se.Interview.howmanycowsin20years;

public class Cow {
    private int age;

    public Cow(int age) {
        super();
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBornable() {
        return age >= 5;
    }

    public Cow lay() {
        return new Cow(0);
    }

    public void grow() {
        age++;
    }

    @Override
    public String toString() {
        return "age=" + age;
    }

}
