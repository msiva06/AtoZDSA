package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

// Stack implementation using queues(2 Queues)
public class Problem_02 {
    
        Queue<Integer> q1;
        Queue<Integer> q2;
        public Problem_02() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return q1.size();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }

        public void push(int element) {
            q2.offer(element);
            while(!isEmpty()){
                q2.offer(q1.poll());
            }
            Queue temp = q1;
            q1 = q2;
            q2 = temp;
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
