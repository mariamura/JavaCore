package com.mariamura.chapter21;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite_beforeJDK7 {
    public static void main(String[] args) {
        FileChannel fchan = null;
        RandomAccessFile fout = null;
        ByteBuffer mbuf;



        try{
            fout = new RandomAccessFile("test.txt", "rw");
            fchan = fout.getChannel();
            mbuf = fchan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for(int i = 0; i<26; i++) {
                mbuf.put((byte) ('A' + i));
            }
        }catch (InvalidPathException |IOException e) {
            System.out.println(e);
            System.exit(1);
        }finally {
            try {
                if (fchan != null) fchan.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
