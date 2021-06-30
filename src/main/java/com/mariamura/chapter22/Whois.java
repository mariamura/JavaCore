package com.mariamura.chapter22;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Whois {
    public static void main(String[] args) throws IOException {
        int c;
        Socket s = new Socket("whois.internic.net", 43);

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        String str = (args.length == 0 ? "MHProfessional.com" : args[0]);
        byte[] buf = str.getBytes(StandardCharsets.UTF_8);
        out.write(buf);

        while((c = in.read()) != -1) {
            System.out.println((char) c);
        }
        s.close();
    }
}
