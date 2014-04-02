package com.j2se.book.crazyseries.project.ball.service;

import java.util.Random;

import com.j2se.book.crazyseries.project.ball.Constants;

public final class Service {

    private Service() {

    }

    public static boolean isBrickRequired() {
        Random random = new Random();
        return random.nextInt(100) < Constants.BRICK_EXIST_PROBALLILITY;
    }

}
