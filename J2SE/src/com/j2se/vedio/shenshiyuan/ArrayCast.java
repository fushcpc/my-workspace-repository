package com.j2se.vedio.shenshiyuan;

public class ArrayCast {
    public static void main(String[] args) {
        // ArrayList list = new ArrayList();
        // list.add(new Integer(1));
        // list.add(new Integer(1));
        // list.add(new Integer(1));
        // list.add(new Integer(1));
        // Integer[] inArray = (Integer[])list.toArray();
        // for(Integer value : inArray){
        // System.out.println(value);
        // }
        // LinkedList<Object> lList = new LinkedList<Object>();

        GenericTest<String> ge1 = new GenericTest<String>();
        ge1.setFoo("hello");
        GenericTest<? extends Object> ge2 = ge1;
        System.out.println(ge2);
        ge2.setFoo(null);
        System.out.println(ge2);
        // ge2.setFoo("welcome");
    }
}

class GenericTest<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
}
