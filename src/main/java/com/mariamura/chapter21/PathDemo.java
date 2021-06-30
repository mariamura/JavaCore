package com.mariamura.chapter21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("example\\test.txt");
        System.out.println(filepath.getName(1) +
                "\n" + filepath +
                "\n" + filepath.toAbsolutePath() +
                "\n" + filepath.getParent());
        if(Files.exists(filepath)) System.out.println("File is exist");
        else
            System.out.println("File is not exist");

        try{
            if(Files.isHidden(filepath))
            System.out.println("File is hidden");
            else
                System.out.println("File is not hidden");
        }catch (IOException e) {
            System.out.println(e);
        }

        try{
            BasicFileAttributes att = Files.readAttributes(filepath, BasicFileAttributes.class);
            if(att.isDirectory()) System.out.println("Is directory");
            else
                System.out.println("Is not directory");
            if(att.isRegularFile()) System.out.println("Is regular file");
            else
                System.out.println("Is not regular file");
            if(att.isSymbolicLink()) System.out.println("Is symbolic link");
            else
                System.out.println("Is not symbolic link");
            System.out.println(att.lastModifiedTime());
            System.out.println(att.size());
        }catch (IOException e) {
            System.out.println(e);
        }

    }
}
