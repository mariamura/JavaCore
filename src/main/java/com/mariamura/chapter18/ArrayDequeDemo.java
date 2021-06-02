package com.mariamura.chapter18;

/*  offer: o(1)
 *  peek: o(1)
 *  poll: o(1)
 *  size: o(1) */

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {

        ArrayDeque<String> adq = new ArrayDeque<>();

        adq.push("A"); //as addFirst this methods add elements in head of Deque
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        adq.offer("G"); //as offerLast this methods add elements on the end of Deque
        adq.poll(); //pollFirst


        System.out.println("adq retrieve from stack: ");

        while(adq.peek() != null) { //as peekFirst this methods retrieves but do not remove element
            System.out.print(adq.pop() + " "); //as removeFirst this methods retrieves and remove element
        }

    }
}
