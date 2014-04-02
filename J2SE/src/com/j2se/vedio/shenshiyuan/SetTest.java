package com.j2se.vedio.shenshiyuan;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add(new String("a"));
        set.add(new String("a"));
        System.out.println(set);
    }
}
