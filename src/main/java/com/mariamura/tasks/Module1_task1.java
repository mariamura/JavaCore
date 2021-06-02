package com.mariamura.tasks;

/*
* Algorithm, that take two arrays and get one sorted array with numbers, that contains in both input arrays.
* Example:
* input arrays [6,4,6,8,1,100,-100], [3,8,76544, -42, 100,1]
* output array [1,8,100]
*/

import java.util.*;

public class Module1_task1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integer arrays");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        String[] s1_1 = s1.replaceAll("[\\[\\],]", " ").split(" ");
        String[] s2_1 = s2.replaceAll("[\\[\\],]", " ").split(" ");

        HashSet<Integer> s1_2 = new HashSet<>(s1_1.length);
        HashSet<Integer> s2_2  = new HashSet<>(s2_1.length);

        for (String v : s1_1) {
            try {
                s1_2.add(Integer.parseInt(v));
            } catch (NumberFormatException e) {
                if (!((v.equals(""))||(v.equals(" ")))) {
                    System.out.println("1st array have non integer symbol: " + v + ", to be removed");
                }
            }
        } //if input array_1 contains non-digit char and remove it from the array_1
        for (String v : s2_1) {
            try {
                s2_2.add(Integer.parseInt(v));
            } catch (NumberFormatException e) {
                if (!((v.equals(""))||(v.equals(" ")))) {
                    System.out.println("2nd array have non integer symbol: " + v + ", to be removed");
                }
            }
        } //if input array_2 contains non-digit char and remove it from the array_2

        s1_2.retainAll(s2_2);
        List<Integer> result = new ArrayList<>(s1_2);

        Collections.sort(result);
        System.out.println(result);

    }

}
