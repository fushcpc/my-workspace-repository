package com.j2se.book.corejava.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Employee[] staffs = new Employee[3];
        Manager manager1 = new Manager("Manager1", 90000);
        Manager manager2 = new Manager("Manager2", 80000);
        Employee secretary = new Employee("secretary", 200);
        manager1.setSecretary(secretary);
        manager2.setSecretary(secretary);
        staffs[0] = manager1;
        staffs[1] = manager2;
        staffs[2] = secretary;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("employee.txt")));
        oos.writeObject(manager1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("employee.txt")));
        Manager manager = (Manager) ois.readObject();
        manager.setSalary(manager.getSalary() + 99);
        ois.close();

        System.out.println(manager.toString());

    }
}
