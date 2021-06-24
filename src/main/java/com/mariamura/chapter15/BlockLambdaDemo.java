package com.mariamura.chapter15;

interface NumericFun {
    int func(int n);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFun factorial = (n) -> {
            int result = 1;
            for (int i=1; i<=n; i++) result = i *result;
            return result;
        };
        System.out.println("Factorial of number 3: " + factorial.func(3));
    }
}
