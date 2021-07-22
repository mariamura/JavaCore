package com.mariamura.chapter28;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new UseString(exgr);
        new MakeString(exgr);
    }
}

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> c) {
        ex=c;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i = 0; i< 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Got: " + str);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;
    MakeString(Exchanger<String> c) {
        ex=c;
        str = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';
        for(int i = 0; i< 3; i++) {
            for(int j = 0; j <5; j++)
                str += (char) ch++;
            try {
                str = ex.exchange(str);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
