package com.mariamura.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead_beforeJDK7 {
    public static void main(String[] args) {

        FileInputStream fin = null;
        FileChannel fch = null;
        MappedByteBuffer mbuf;

        try {
            fin = new FileInputStream("test.txt");
            fch = fin.getChannel();
            long fsize = fch.size();
            mbuf = fch.map(FileChannel.MapMode.READ_ONLY, 0, fsize);

            for(int i = 0; i<fsize; i++){
                System.out.print((char)mbuf.get());
            }
            System.out.println();

        }catch (InvalidPathException | IOException e) {
            System.out.println(e);
        }finally {
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
