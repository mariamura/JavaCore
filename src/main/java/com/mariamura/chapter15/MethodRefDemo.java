package com.mariamura.chapter15;

interface StringFunc3 {
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        int i;
        for(i=str.length()-1; i>=0; i--) result+=str.charAt(i);
        return result;
    }
}

public class MethodRefDemo {
    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Hello, user";
        String outStr;
        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println(outStr);
    }
}
