package com.mariamura.chapter20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumeration implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumeration(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        }catch (IOException e) {
            return null;
        }
    }
}

class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();
        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        InputStreamEnumeration ise = new InputStreamEnumeration(files);
        InputStream input = new SequenceInputStream(ise);
        try {
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        }catch (NullPointerException e) {
            System.out.println("Error file open " + e);

        }catch (IOException e) {
            System.out.println("IO error " + e);

        }finally {
            try{
                input.close();
            }catch (IOException e) {
                System.out.println("Error close sequence input stream");
            }
        }
    }
}
