package com.mariamura.chapter10;

public class MultipleCatches {
    public static void main(String[] args) {
        try{
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42/a;
            int[] c = {1};
            c[42] = 99;
        }catch (ArithmeticException e){
            System.out.println("Divided by zero:" + e);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Out of array..Wrong index: " + e);
        }
        System.out.println("After all catch operators");
    }
}
