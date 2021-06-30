package com.mariamura.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitChannelRead_beforeJDK7 {
    public static void main(String[] args) {
        int count;
        FileInputStream fin = null;
        FileChannel fch = null;
        ByteBuffer mbuf;
        try {
            fin = new FileInputStream("test.txt");
            fch = fin.getChannel();
            mbuf = ByteBuffer.allocate(128);

            do {
                count = fch.read(mbuf);
                if (count != -1) {
                    mbuf.rewind();
                    for (int i = 0; i < count; i++) System.out.print((char) mbuf.get());
                }
            } while (count == 1);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fch != null) fch.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
