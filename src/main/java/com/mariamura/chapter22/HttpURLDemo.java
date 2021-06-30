package com.mariamura.chapter22;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpC = (HttpURLConnection) hp.openConnection();

        System.out.println(hpC.getRequestMethod());
        System.out.println(hpC.getResponseCode());
        System.out.println(hpC.getResponseMessage());

        Map<String, List<String>> map = hpC.getHeaderFields();
        Set<String> set = map.keySet();
        System.out.println();

        for(String s: set) {
            System.out.print(s + ": " + map.get(s)+"\n");
        }
    }
}
