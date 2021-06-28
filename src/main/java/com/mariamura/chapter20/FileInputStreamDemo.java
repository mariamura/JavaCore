package com.mariamura.chapter20;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        int size;
        try(FileInputStream f = new FileInputStream("File.java")) {
            System.out.println("Byte available: " + (size = f.available()));
            int n = size / 40;
            System.out.println(f.available());
            byte[] b = new byte[n];
            if (f.read(b) != 0) {
                System.out.println("can read " + n + "byte");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("Byte available: " + (size = f.available()));
            System.out.println("Skip half of available byte");
            f.skip(size / n);
            System.out.println("Byte available: " + f.available());
            System.out.println("Read " + n / 2 + "byte in the end of array");

            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("Can read " + n / 2 + " byte");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("Byte available: " + f.available());
        }catch (IOException e) {
            System.out.println("Input output error " + e);

        }
    }
}
