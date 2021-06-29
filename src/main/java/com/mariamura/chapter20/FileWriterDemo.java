package com.mariamura.chapter20;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        String source = "Hello user!\n" + "Are you ready for coding today?";
        char[] buff = new char[source.length()];
        source.getChars(0, source.length(), buff, 0);
        try(FileWriter f0 = new FileWriter("file1.txt");
            FileWriter f1 = new FileWriter("file2.txt");
            FileWriter f2 = new FileWriter("file3.txt")) {
            for(int i=0; i<buff.length; i+=2){
                f0.write(buff[i]);
            }
            f1.write(buff);
            f2.write(buff, buff.length-buff.length/4, buff.length/4);
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
