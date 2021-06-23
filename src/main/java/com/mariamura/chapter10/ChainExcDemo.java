package com.mariamura.chapter10;

public class ChainExcDemo {
    static void demoproc() {
        NullPointerException e = new NullPointerException("upper level");
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }

    public static void main(String[] args) {
        try{
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Catch exception: " + e);
            System.out.println("Initial cause: " + e.getCause());
        }
    }
}
