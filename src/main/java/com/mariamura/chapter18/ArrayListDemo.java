package com.mariamura.chapter18;




import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        //create ArrayList
        ArrayList<String> al = new ArrayList<>();

        System.out.println("ArrayList al was created. Initial al size: " + al.size());

        //add elements
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");

        System.out.println("al size after elements added: " + al.size());

        //arraylist content
        System.out.println("al content: " + al);

        //delete elements
        al.remove("F");
        al.remove(2);

        System.out.println("al size after elements deleted: " + al.size());
        System.out.println("al content: " + al);

    }
}
