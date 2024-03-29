package com.mariamura.chapter15;

interface SomeFunc<T> {
    T func(T t);
}

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length()-1; i>=0; i--) result = result + str.charAt(i);
            return result;
        };

        System.out.println(reverse.func("Hello World"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i<=n; i++) {
                result = result * i;
            }
            return result;
        };

        System.out.println(factorial.func(3));
    }

}
