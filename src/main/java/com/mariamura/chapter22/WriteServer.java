package com.mariamura.chapter22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class WriteServer {
    static int serverPort = 988;
    static int clientPort = 999;
    static int buffer_size = 1024;
    static DatagramSocket ds;
    static byte[] buff = new byte[buffer_size];

    public static void TheServer() throws IOException {
        int pos = 0;
        while(true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Server closing..");
                    ds.close();
                    break;
                case '\r': break;
                case '\n':
                    ds.send(new DatagramPacket(buff, pos, InetAddress.getLocalHost(), clientPort));
                    pos=0;
                    break;
                default:
                    buff[pos++] = (byte) c;
            }
        }
    }

    public static void TheClient() throws IOException {
        while(true){
            DatagramPacket p = new DatagramPacket(buff, buff.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String[] args) throws IOException {
        if(args.length == 1) {
            ds = new DatagramSocket(serverPort);
            TheServer();
        } else {
            ds = new DatagramSocket(clientPort);
            TheClient();
        }
    }

}
