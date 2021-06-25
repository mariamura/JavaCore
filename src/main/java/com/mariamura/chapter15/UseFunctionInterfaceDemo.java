package com.mariamura.chapter15;

import java.util.function.Function;

public class UseFunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = n -> {
            int res = 1;
            for (int i = 1; i<=n; i++) res += res*i;
            return res;
        };


        System.out.println(factorial.apply(5));
    }
}
