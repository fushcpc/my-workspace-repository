package com.j2se.book.corejava.chapter3.fundamental;

import java.io.Console;
import java.util.Arrays;

public class UseConsoleToInputPassword {
    public static void main(String[] args) {
        Console console = System.console();
        // this console will be null if you run this application in Eclipse or
        // other IDE
        // but it won't if you run it in CMD or Terminator(see Console's API)
        System.out.println(console);
        String username = console.readLine("User Name:");
        char[] passwd = console.readPassword("Fbdc@2012");
        System.out.println("The informatinon you input is as below:");
        System.out.println("username = " + username);
        System.out.println("password = " + Arrays.toString(passwd));
    }
}
