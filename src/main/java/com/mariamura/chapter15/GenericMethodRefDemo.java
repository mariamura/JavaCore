package com.mariamura.chapter15;

interface MyFunc3<T> {
    int func(T[] vals, T v2);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for(T i : vals) {
            if(i == v) count++;
        }
        return count;
    }
}

public class GenericMethodRefDemo {
    static <T> int myOp(MyFunc3<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 6, 4, 4, 2};
        String[] strs = {"one", "two", "three", "two"};
        int count;
        count = myOp(MyArrayOps::countMatching, vals, 4);
        System.out.println(count);
        count = myOp(MyArrayOps::countMatching, strs, "two");
        System.out.println(count);
    }
}
