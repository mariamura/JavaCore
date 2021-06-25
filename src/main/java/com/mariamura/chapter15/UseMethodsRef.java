package com.mariamura.chapter15;


import java.util.ArrayList;
import java.util.Collections;

class MyClass{
    private int val;
    MyClass(int v) {
        val = v;
    }
    int getVal() {
        return val;
    }
}

public class UseMethodsRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> ar = new ArrayList();
        ar.add(new MyClass(1));
        ar.add(new MyClass(4));
        ar.add(new MyClass(2));
        ar.add(new MyClass(9));
        ar.add(new MyClass(3));
        ar.add(new MyClass(7));

        MyClass maxValObg = Collections.max(ar, UseMethodsRef::compareMC);
        System.out.println(maxValObg.getVal());

    }
}
