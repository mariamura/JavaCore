package com.mariamura.chapter18;

import java.util.ArrayList;

public class ForEachDemo {
    public static void main(String[] args) {
        ArrayList<Integer> vals = new ArrayList<>();

        for (int i = 1; i<6; i++) vals.add(i);

        System.out.print("Initial vals content: ");
        for (int i : vals) {
            System.out.print(i + " ");
        }

        System.out.println();

        int sum = 0;
        for (int i: vals) sum+=i;
        System.out.println("Sum of vals elements: " + sum);
    }
}
