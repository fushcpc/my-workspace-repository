package com.david.designpattern.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStreamTester {
    public static void main(String[] args) throws IOException {
        InputStream in = new LowerCaseInputStream(new BufferedInputStream(
                new FileInputStream("test.txt")));
        for (int c = in.read(); c >= 0; c = in.read()) {
            System.out.println((char) c);
        }
        in.close();
    }
}
