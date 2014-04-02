package com.j2se.Interview.mainmethod;

/**
 * If i do not provide any argument on the command line, 
 * then the string array of Main method will be empty or null?
 * @author Administrator
 *
 */
public class MainMethod {
    public static void main(String[] args) {
        System.out.println(args == null);//false
        System.out.println(args.length);//0
    }
}
