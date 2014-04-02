package com.j2se.book.corejava.chapter3.fundamental;

import java.util.Scanner;

public class BreakTagInForloop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        read_data: while (true) {
            System.out.println("while loop is called.");
            for (int i = 1; i != 0;) {
                System.out.println("Enter a number >= 0 :");
                i = in.nextInt();
                if (i < 0) {
                    break read_data;
                }
            }
        }
    }
}
