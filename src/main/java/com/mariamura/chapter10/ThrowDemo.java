package com.mariamura.chapter10;

public class ThrowDemo {
    static void demoproc() {
        try{
            throw new NullPointerException("Demonstrate");
        }catch (NullPointerException e) {
            System.out.println("In demproc() method body.");
            throw e;
        }
    }

    public static void main(String[] args) {
        try{
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Second catch: " + e);
        }
    }
}
