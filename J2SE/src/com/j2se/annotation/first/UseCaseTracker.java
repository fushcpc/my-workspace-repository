package com.j2se.annotation.first;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 10, 11, 13);
        trackUseCases(useCases, UseCaseTest.class);
    }

    private static void trackUseCases(List<Integer> useCases,
            Class<UseCaseTest> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer missedUseCaseId : useCases) {
            System.out.println("Warning missing use case:" + missedUseCaseId);
        }
    }
}
