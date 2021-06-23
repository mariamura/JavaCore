package com.mariamura.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin;
        if (args.length!=1) {
            System.out.println("Using: ShowFile file_name");
        }

        try {
            fin = new FileInputStream(args[0]);
        }catch (FileNotFoundException e) {
            System.out.println("Can not open file");
            return;
        }

        try {
            do {
                i = fin.read();
                if(i!=-1) System.out.println((char) i);
            }while(i!=1);
        }catch (IOException e) {
            System.out.println("Error while file reading");
        }
        try {
            fin.close();
        }catch (IOException e) {
            System.out.println("Error while file closing");
        }
    }
}
