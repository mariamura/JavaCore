package com.mariamura.chapter11;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " in method A.foo()");
        try{
            Thread.sleep(1000);
        }catch (Exception e) {
            System.out.println("class A interrupted");
        }
        System.out.println(name + " try to call  method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("In method A.last()");
    }

}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " in method B.bar()");
        try{
            Thread.sleep(1000);
        }catch (Exception e) {
            System.out.println("class B interrupted");
        }
        System.out.println(name + " try to call  method B.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("In method B.last()");
    }

}

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "Second thread");
        t.start();
        a.foo(b);
        System.out.println("Back to main thread");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Back to thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
