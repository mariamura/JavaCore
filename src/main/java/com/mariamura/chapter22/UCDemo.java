package com.mariamura.chapter22;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws IOException {
        int c;
        URL hp = new URL("http://www.internic.net");
        URLConnection hpC = hp.openConnection();


        long d = hpC.getDate();
        if(d==0) System.out.println("date info not available");
        else
            System.out.println("Date: " + new Date(d));

        System.out.println(hpC.getContentType());

        d = hpC.getExpiration();
        if(d==0) System.out.println("date expiration not available");
        else
            System.out.println("Date: " + new Date(d));

        d = hpC.getLastModified();
        if(d==0) System.out.println("last mod not available");
        else
            System.out.println("last mod: " + new Date(d));

        long len = hpC.getContentLengthLong();
        if(len==-1) System.out.println("length content not available");
        else
            System.out.println("length content: " + len);
        if(len != 0) {
            System.out.println("=====Content=====");
            InputStream in = hpC.getInputStream();
            while((c = in.read()) != -1) System.out.print((char)c);
        }
        else {
            System.out.println("Content not available");
        }
    }
}
