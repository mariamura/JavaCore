package com.mariamura.chapter18;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i<10; i++) array[i] = -3*i;

        System.out.print("initial array content: ");
        display(array);

        Arrays.sort(array);
        System.out.print("array content after sorting ");
        display(array);

        Arrays.fill(array, 2, 6, -1);
        System.out.print("array content after calling fill method: ");
        display(array);

        Arrays.sort(array);
        System.out.print("array after second sort: ");
        display(array);

        System.out.print("Number -9 is on position: ");
        int index = Arrays.binarySearch(array, -9); //only after calling sort method!
        System.out.println(index);

    }
    static void display(int[] array) {
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }
}
