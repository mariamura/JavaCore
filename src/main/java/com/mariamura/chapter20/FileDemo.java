package com.mariamura.chapter20;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }


    public static void main(String[] args) {
        File f1 = new File("/java/COPYRIGHT");
        p(f1.getName());
        p(f1.getPath());
        p(f1.getAbsolutePath());
        p(f1.exists() ? "exist" : "not exist");
        p(f1.canWrite() ? "can write" : "can not write");
        p(f1.canRead() ? "can read" : "can not read");
        p(f1.isDirectory() ? "directory" : "not directory");
        p(f1.isFile() ? "file" : "not file");
        p(f1.isAbsolute() ? "absolute" : "not absolute");
        p(f1.lastModified() + " last modified");
        p(f1.length() + " file size byte");


    }
}
