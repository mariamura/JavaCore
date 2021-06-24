package com.mariamura.chapter15;

interface MyNumber {
    double getValue();
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyNumber myNum;

        myNum = () -> 123.45;
        System.out.println(myNum.getValue());

        myNum = () -> Math.random()*100;

        System.out.println(myNum.getValue());
        System.out.println(myNum.getValue());

    }
}
