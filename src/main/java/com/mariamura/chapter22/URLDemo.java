package com.mariamura.chapter22;

import java.io.IOException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL hp = new URL("http://www.HerbSchildt.com/Articles");

        System.out.println(hp.getProtocol());
        System.out.println(hp.getPort());

        System.out.println(hp.getHost());
        System.out.println(hp.getFile());

        System.out.println(hp.toExternalForm());
    }
}
