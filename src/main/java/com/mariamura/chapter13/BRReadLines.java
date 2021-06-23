package com.mariamura.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter text line.");
        System.out.println("Enter q for exit.");
        do {
            str = br.readLine();
            System.out.println(str);
        }while(!str.equals("q"));
    }
}
