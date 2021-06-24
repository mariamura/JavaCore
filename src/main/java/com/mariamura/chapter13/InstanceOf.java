package com.mariamura.chapter13;

public class InstanceOf {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        if (a instanceof A) System.out.println("a instance of A");

        if (b instanceof B) System.out.println("b instance of B");

        if (c instanceof C) System.out.println("c instance of C");

        if (c instanceof A) System.out.println("c instance of A");

        if (a instanceof C) System.out.println("a instance of C");

        System.out.println();


        A ob;
        ob=d;
        System.out.println("ob is d");
        if (ob instanceof  D) System.out.println("ob instance of D");
        System.out.println();
        ob=c;
        System.out.println("ob is c");
        if(ob instanceof D) System.out.println("ob instance of D");
        else System.out.println("ob not instance of D");

        if(ob instanceof A) System.out.println("ob instance of A");

        System.out.println();

        if (a instanceof Object) System.out.println("a instance of Object");
        if (b instanceof Object) System.out.println("b instance of Object");
        if (c instanceof Object) System.out.println("c instance of Object");
        if (d instanceof Object) System.out.println("d instance of Object");

    }
}
class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}