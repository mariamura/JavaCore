package com.mariamura.chapter10;

public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("In throwOne() method body");
        throw new IllegalAccessException("Demonstrate");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Catch exception: " + e);
        }
    }
}
