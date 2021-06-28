package com.mariamura.chapter20;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        String dirname = "C:\\Program Files\\Java\\jre1.8.0_291";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Directory: " + dirname);
            String[] s = f1.list();

            for(String content: s) {
                File f = new File(dirname + "/" + content);
                if (f.isDirectory()) {
                    System.out.println(s + " is directory");
                } else {
                    System.out.println(s + " is file");
                }
            }

        } else {
            System.out.println(dirname + " is not directory");
        }
    }
}
