package StacksAndQueues;

import java.util.Stack;

// Implementation of queue using stack
public class Problem_05 {
    static class Queue {
        // Define the data members(if any) here.
        Stack<Integer> s1;
        Stack<Integer> s2;
        Queue() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }

        void enQueue(int val) {
            while(!isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(val);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        int deQueue() {
            if(!isEmpty())
                return s1.pop();
            return -1;
        }

        int peek() {
            if(!isEmpty())
                return s1.peek();
            return -1;
        }

        boolean isEmpty() {
            return s1.isEmpty();
        }
    }
}
