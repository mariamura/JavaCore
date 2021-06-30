package com.mariamura.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        try(FileChannel fchan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE) ) {
            MappedByteBuffer mbuf = fchan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for(int i = 0; i<26; i++) {
                mbuf.put((byte) ('A' + i));
            }
        }    catch (InvalidPathException |IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

}
