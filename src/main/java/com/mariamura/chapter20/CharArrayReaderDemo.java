package com.mariamura.chapter20;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String tmp = "abcdefght...";
        int length = tmp.length();
        char[] c = new char[length];
        tmp.getChars(0, length, c, 0);
        int i;
        try(CharArrayReader in1 = new CharArrayReader(c)) {
            System.out.println("in1:");
            while ((i=in1.read())!=-1) {
                System.out.print((char) i);
            }
            System.out.println();
        }catch (IOException e) {
            System.out.println(e);
        }

        try(CharArrayReader in2 = new CharArrayReader(c, 0, 5)){
            System.out.println("in2:");
            while ((i=in2.read())!=-1){
                System.out.print((char) i);
            }
            System.out.println();
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
