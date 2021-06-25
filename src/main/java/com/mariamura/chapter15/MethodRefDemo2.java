package com.mariamura.chapter15;

class MyStringOps2 {
    String strReverse(String str) {
        String result = "";
        int i;
        for(i=str.length()-1; i>=0; i--) result+=str.charAt(i);
        return result;
    }
}


public class MethodRefDemo2 {
    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Hello, user";
        String outStr;

        MyStringOps2 strOps = new MyStringOps2();

        outStr = stringOp(strOps::strReverse, inStr);
        System.out.println(outStr);
    }
}
