package com.j2se.book.corejava.chapter3.fundamental;

import java.util.Scanner;

public class WhatHappenWhenScannerNextIntGetChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old are you?");
        // if you input string in here, you get the
        // java.util.InputMismatchException
        int age = scanner.nextInt();
        System.out.println("You will be " + ++age + " old next year");
    }
}
