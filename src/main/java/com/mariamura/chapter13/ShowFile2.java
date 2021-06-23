package com.mariamura.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile2 {
    public static void main(String[] args) throws IOException {
        int i;
        if (args.length!=1) {
            System.out.println("Using: ShowFile file_name");
        }

        try(FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if(i!=-1) System.out.println((char) i);
            }while(i!=1);
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error while file reading");
        }
    }
}
