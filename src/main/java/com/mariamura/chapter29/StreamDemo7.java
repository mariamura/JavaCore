package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamDemo7 {
    public static void main(String[] args) {

        ArrayList<NamePhoneEmail> l = new ArrayList<>();
        l.add(new NamePhoneEmail("Larry", "555-555", "larr@gmail.com"));
        l.add(new NamePhoneEmail("James", "555-666", "jame@gmail.com"));
        l.add(new NamePhoneEmail("Mary", "555-777", "mary@gmail.com"));


        Stream<NamePhone> phnumbrs = l.stream().map(a -> new NamePhone(a.name, a.number));
        List<NamePhone> npl = phnumbrs.collect(Collectors.toList());
        for(NamePhone e: npl) System.out.println(e.name + ": " + e.number);

        System.out.println();


        phnumbrs = l.stream().map(a -> new NamePhone(a.name, a.number));
        Set<NamePhone> nps = phnumbrs.collect(Collectors.toSet());
        for(NamePhone e: nps) System.out.println(e.name + ": " + e.number);


    }
}
