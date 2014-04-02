package com.j2se.book.crazyseries.project.ball;

import java.awt.EventQueue;

import com.j2se.book.crazyseries.project.ball.bean.BallGameFrame;

public class Lancher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BallGameFrame();
            }
        });
    }
}
