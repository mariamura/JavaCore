package com.mariamura.chapter15;

interface MyFunc4 {
    MyClass2 func(int n);
}

class MyClass2{
    private int val;
    MyClass2(int v) {
        val = v;
    }
    MyClass2() {
        val = 0;
    }
    int getVal() {
        return val;
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        MyFunc4 myClassConst = MyClass2::new;
        MyClass2 mc = myClassConst.func(100);
        System.out.println(mc.getVal());
    }
}
