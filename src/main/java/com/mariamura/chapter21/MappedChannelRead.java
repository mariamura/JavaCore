package com.mariamura.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fchan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"))) {
            long fsize = fchan.size();
            MappedByteBuffer mbuf = fchan.map(FileChannel.MapMode.READ_ONLY, 0, fsize);
            for(int i = 0; i<fsize; i++){
                System.out.print((char)mbuf.get());
            }
            System.out.println();

        }catch (InvalidPathException | IOException e) {
            System.out.println(e);
        }
    }
}
