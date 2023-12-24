package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

// Implementation of stack using queue
public class Problem_04 {
    static class Stack {
        Queue<Integer> q1;
        
        public Stack() {
            q1 = new LinkedList<>();
            
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return q1.size();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }

        public void push(int element) {
            q1.offer(element);
            for(int i = 0; i < q1.size()-1;i++){
                 q1.offer(q1.poll());
            }
        }

        public int pop() {
            if(isEmpty())
                return -1;
            return q1.poll();
        }

        public int top() {
            if(isEmpty())
                return -1;
            return q1.peek();
        }
    }
}
