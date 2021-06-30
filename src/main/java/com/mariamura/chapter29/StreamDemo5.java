package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String number;
    String email;

    public NamePhoneEmail(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String number;

    public NamePhone(String name, String number) {
        this.name = name;
        this.number = number;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {

        ArrayList<NamePhoneEmail> l = new ArrayList<>();
        l.add(new NamePhoneEmail("Larry", "555-555", "larr@gmail.com"));
        l.add(new NamePhoneEmail("James", "555-666", "jame@gmail.com"));
        l.add(new NamePhoneEmail("Mary", "555-777", "mary@gmail.com"));

        l.stream().forEach(n -> System.out.println(n.name + " " + n.number + " " + n.email));
        System.out.println();

        Stream<NamePhone> phnumbrs = l.stream().map(a -> new NamePhone(a.name, a.number));
        phnumbrs.forEach(a -> System.out.println(a.name + " " + a.number));

    }
}
