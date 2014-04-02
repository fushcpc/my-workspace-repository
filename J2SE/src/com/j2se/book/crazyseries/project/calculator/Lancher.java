package com.j2se.book.crazyseries.project.calculator;

import java.awt.EventQueue;

public class Lancher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorFrame().setVisible(true);
            }
        });
    }
}
