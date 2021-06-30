package com.mariamura.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "\\MyDir";
        DirectoryStream.Filter<Path> how = filename -> {
            return Files.isWritable(filename);
        };
        //DirectoryStream.Filter<Path> how = Files::isWritable;

        try (DirectoryStream<Path> dirstr = Files.newDirectoryStream(Paths.get(dirname), how))

        {
            System.out.println(dirname);

            for (Path entry : dirstr) {
                BasicFileAttributes att = Files.readAttributes(entry, BasicFileAttributes.class);
                if (att.isDirectory()) System.out.println("<DIR> ");
                else
                    System.out.println("     ");
                System.out.println(entry.getName(1));
            }
        }catch (InvalidPathException| NotDirectoryException e) {
            System.out.println(e);
        }catch (IOException e) {
            System.out.println(e);
        }
    }

}
