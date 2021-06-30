package com.mariamura.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite_beforeJDK7 {
    public static void main(String[] args) {
        FileChannel fchan = null;
        FileOutputStream fout = null;
        ByteBuffer mbuf;

        try{
            fout = new FileOutputStream("test.txt");
            fchan = fout.getChannel();
            mbuf = ByteBuffer.allocate(26);
            for(int i = 0; i<26; i++) {
                mbuf.put((byte) ('A' + i));
            }
            mbuf.rewind();
            fchan.write(mbuf);

        }    catch (InvalidPathException |IOException e) {
            System.out.println(e);
            System.exit(1);
        } finally {
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
