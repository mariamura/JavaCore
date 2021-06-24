package com.mariamura.chapter13;

public class NativeDemo {
    int i;

    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();
        ob.i = 10;
        System.out.println("ob.i before native method call");
        ob.test();
        System.out.println("ob.i after native method call");
    }
    public native void test();
    static {
        System.loadLibrary("NativeDemo");
    }
}
