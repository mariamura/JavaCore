package com.mariamura.chapter20;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) throws IOException {
        CharArrayWriter f = new CharArrayWriter();
        String s = " This is data should be in array..";
        char[] buff = new char[s.length()];
        s.getChars(0, s.length(), buff, 0);
        try{
            f.write(buff);
        }catch (IOException e) {
            System.out.println(e);
            return;
        }

        System.out.println(f.toString());
        char[] c = f.toCharArray();
        for (char c0: c) System.out.print(c0);

        try(FileWriter f2 = new FileWriter("test.txt")) {
            f.writeTo(f2);
        }catch (IOException e) {
            System.out.println(e);
        }
        f.reset();
        System.out.println();
        for (int i = 0; i<3; i++) f.write('X');

        System.out.println(f.toString());
    }
}
