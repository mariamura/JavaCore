package com.mariamura.chapter20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        String source = "Hello World!\nnew line";
        byte[] buf = source.getBytes(StandardCharsets.UTF_8);
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        try{
            f0 = new FileOutputStream("file1.txt");
            f1 = new FileOutputStream("file2.txt");
            f2 = new FileOutputStream("file3.txt");
            for (int i = 0; i<buf.length; i++) {
                f1.write(buf[i]);
            }
            f1.write(buf);
            f2.write(buf, buf.length-buf.length/4, buf.length/4);
        }catch (IOException e) {
            System.out.println("error");
        }finally {
            try {
                if (f0 != null) f0.close();
            } catch (IOException e) {
                System.out.println("f1 close error");
            }
            try {
                if (f1 != null) f1.close();
            } catch (IOException e) {
                System.out.println("f2 close error");
            }
            try {
                if (f2 != null) f2.close();
            } catch (IOException e) {
                System.out.println("f3 close error");
            }
        }
    }
}
