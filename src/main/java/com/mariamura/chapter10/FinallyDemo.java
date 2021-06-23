package com.mariamura.chapter10;

public class FinallyDemo {
    static void procA() {
        try {
            System.out.println("In procA() method body");
            throw new RuntimeException("demonstrate");
        }finally {
            System.out.println("finally in procA() method");
        }
    }

    static void procB() {
        try {
            System.out.println("In procB() method body");
            return;
        }finally {
            System.out.println("finally in procB() method");
        }
    }

    static void procC() {
        try {
            System.out.println("In procC() method body");
        }finally {
            System.out.println("finally in procC() method");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        }catch (Exception e) {
            System.out.println("Catch exception");
        }
        procB();
        procC();
    }
}
