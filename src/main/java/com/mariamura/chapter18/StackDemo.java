package com.mariamura.chapter18;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        System.out.println("stack: " + st);

        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);

        try{
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }

    }
    static void showpush(Stack<Integer> st, int a) {
        st.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }
    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        int a = st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }
}
