package com.mariamura.chapter10;

class MyException extends Exception {
    private int detail;

    MyException(int a) {
        detail = a;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail = " + detail +
                '}';
    }
}

public class ExceptionDemo {
    static void compute(int a) throws MyException {
        System.out.println("compute(" + a + ") called");
        if (a>10)
            throw new MyException(a);
        System.out.println("All ok");
    }

    public static void main(String[] args) {
        try{
            compute(11);
        }catch (MyException e){
            System.out.println("Catch exception: " + e);
        }
    }
}
