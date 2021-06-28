package com.mariamura.chapter20;

import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

public class DirListOnly {
    public static void main(String[] args) {
        String dirname = "C:\\Program Files\\Java\\jre1.8.0_291";
        FilenameFilter only = new OnlyExt("html");
        File f1 = new File(dirname);
        String[] s = f1.list(only);
        for (String content:s){
            System.out.println(content);
        }
    }
}
