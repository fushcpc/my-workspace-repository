package com.j2se.vedio.shenshiyuan.innerclass;

class MemberOuter {
    private int i = 2;

    public class MemberInner {
        private int i = 3;

        public void doSomething() {
            System.out.println(i);// 3
            System.out.println(MemberOuter.this.i);// 2
        }
    }
}

public class MemberInnerClassTest {
    public static void main(String[] args) {
        MemberOuter.MemberInner inner = new MemberOuter().new MemberInner();
        inner.doSomething();
    }

}
