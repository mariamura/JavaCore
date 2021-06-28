package com.mariamura.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass ob1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("ob1: " + ob1);
            objOStrm.writeObject(ob1);
        }catch (IOException e) {
            System.out.println("Exception while serialization: " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass ob2 = (MyClass)objIStrm.readObject();
            System.out.println("ob2: " + ob2);
        }catch (Exception e) {
            System.out.println("Exception while deserialization: " + e);
            System.exit(0);
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}
