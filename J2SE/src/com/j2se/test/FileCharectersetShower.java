package com.j2se.test;

import java.io.File;
import java.io.FileInputStream;

public class FileCharectersetShower {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream(new File("G:\\FileBackup\\forum.bak"));
        byte[] b = new byte[10];
        in.read(b, 0, 5);

        for (byte a : b) {
            System.out.println(a);
        }

    }
}
