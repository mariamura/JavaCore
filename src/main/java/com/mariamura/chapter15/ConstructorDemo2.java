package com.mariamura.chapter15;

interface MyFunc5<T> {
    MyClass3<T> func(T n);
}

class MyClass3<T>{
    private T val;
    MyClass3(T v) {
        val = v;
    }
    MyClass3() {
        val = null;
    }
    T getVal() {
        return val;
    }
}

public class ConstructorDemo2 {
    public static void main(String[] args) {
        MyFunc5<Integer> myClassConst = MyClass3::new;
        MyClass3<Integer> mc = myClassConst.func(100);
        System.out.println(mc.getVal());
    }
}
