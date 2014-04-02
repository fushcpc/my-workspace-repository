package com.jimmy.sourceinsignt.aop.jdkaop;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From RealSubject!");
    }

}
