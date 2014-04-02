package com.j2se.book.corejava.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

@SuppressWarnings("unused")
public class FileDirectory {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("employee.dat")));

    }
}
