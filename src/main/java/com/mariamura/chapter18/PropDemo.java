package com.mariamura.chapter18;

import java.util.Properties;
import java.util.Set;

public class PropDemo {
    public static void main(String[] args) {
        Properties capitals = new Properties();
        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "J-City");
        capitals.put("Washington", "Olimpia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        Set<?> states = capitals.keySet();

        for(Object name : states) {
            System.out.println("Capital of state " + name + " - " + capitals.getProperty((String) name) + ".");
        }
        System.out.println();


        String str = capitals.getProperty("Florida", "not found");
        System.out.println("Capital of state Florida " + str + ".");

    }
}
