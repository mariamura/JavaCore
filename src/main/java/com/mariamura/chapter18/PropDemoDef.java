package com.mariamura.chapter18;

import java.util.Properties;
import java.util.Set;

public class PropDemoDef {
    public static void main(String[] args) {
        Properties defList = new Properties();

        defList.put("Florida", "Tallahassee");
        defList.put("Wisconsin", "Madison");

        Properties capitals = new Properties(defList);

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


        String str = capitals.getProperty("Florida");
        System.out.println("Capital of state Florida - " + str + ".");
    }
}
