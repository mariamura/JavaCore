package com.mariamura.chapter15;

interface MyFunc{
    int func(int n);
}

public class VarCapture {
    public static void main(String[] args) {
        int num = 10;
        MyFunc myLambda = n -> {
            int v = num+n;
            //num++;
            return v;
        };
    }
}
