package com.mariamura.chapter15;

import java.util.Locale;

interface StringFunc2 {
    String func(String n);
}

public class LambdaAsArgumentsDemo {

    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Some text...";
        String outStr;
        System.out.println("inStr content: " + inStr);

        outStr = stringOp(str -> str.toUpperCase(Locale.ROOT), inStr);
        System.out.println("inStr in uppercase: " + outStr);

        outStr = stringOp(str -> str.replaceAll(" ", ""), inStr);
        System.out.println("inStr without spaces: " + outStr);

        StringFunc2 reverse = str -> {
            String result = "";
            int i;
            for(i=str.length()-1; i>=0; i--) {
                result = result + str.charAt(i);
            }
            return result;
        };

        System.out.println(stringOp(reverse, inStr));

    }


}
