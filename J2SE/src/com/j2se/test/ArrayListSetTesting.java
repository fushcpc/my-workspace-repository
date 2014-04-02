package com.j2se.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ArrayListSetTesting {
    @SuppressWarnings("unused")
    public static void main(String args[]) {
        Collection<String> a = new HashSet<String>();
        List<String> testList = new ArrayList<String>(10);
        testList.set(3, "a");// Exception in thread "main"
                             // java.lang.IndexOutOfBoundsException: Index: 3,
                             // Size: 0
        new ArrayListSetTesting();

    }
}
