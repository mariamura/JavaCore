package com.mariamura.chapter20;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "Hello world!";
        byte[] b = s.getBytes(StandardCharsets.UTF_8);
        try{
            f.write(b);
        } catch (IOException e) {
            System.out.println("Write buffer error");
            return;
        }
        System.out.println(f.toString());
        byte[] b1 = f.toByteArray();
        for (byte by: b1) {
            System.out.println(by);
        }

        try(FileOutputStream f2 = new FileOutputStream("test.txt")){
            f.writeTo(f2);
        }catch (IOException e) {
            System.out.println("IO error" + e);
            return;
        }
        f.reset();
        for (int i = 0; i<3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
