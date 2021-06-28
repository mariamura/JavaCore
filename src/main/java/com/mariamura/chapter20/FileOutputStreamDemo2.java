package com.mariamura.chapter20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        String source = "Hello World!\nnew line";
        byte[] buf = source.getBytes(StandardCharsets.UTF_8);
        try (FileOutputStream f0 = new FileOutputStream("file1.txt");
             FileOutputStream f1 = new FileOutputStream("file2.txt");
             FileOutputStream f2 = new FileOutputStream("file3.txt"))
        {

            for (int i = 0; i<buf.length; i++) {
                f1.write(buf[i]);
            }
            f1.write(buf);
            f2.write(buf, buf.length-buf.length/4, buf.length/4);
        }catch (IOException e) {
            System.out.println("error");
        }
    }
}
