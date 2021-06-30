package com.mariamura.chapter21;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }
}

public class DirListTree {
    public static void main(String[] args) {
        String dirname = "\\MyDir";
        System.out.println(dirname);

        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
