package com.j2se.vedio.shenshiyuan;

import java.util.HashSet;

public class HashCodeTest {
    public static void main(String[] args) {
        Person p1 = new Person("name");
        Person p2 = new Person("name2");

        HashSet<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);

        System.out.println(set);
    }

}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
