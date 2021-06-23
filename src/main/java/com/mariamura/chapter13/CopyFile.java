package com.mariamura.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        if (args.length!=1) {
            System.out.println("Using: CopyFile fileIn_name fileOut_name");
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            do {
                i = fin.read();
                if(i != -1) fout.write(i);
            }while (i!= -1);
        }catch (IOException e) {
            System.out.println("Error during reading writing");
        }finally {
            try {
                if(fin!=null) fin.close();
            }catch (IOException e) {
                System.out.println("Error during file input close");
            }

            try {
                if(fout!=null) fout.close();
            }catch (IOException e) {
                System.out.println("Error during file output close");
            }
        }



    }
}
