package StacksAndQueues;

import java.util.Stack;

class Pair{
    int num;
    int minSoFar;
    public Pair(int num,int minSoFar){
        this.num = num;
        this.minSoFar = minSoFar;
    }
}
// Min Stack
public class Problem_09 {
    static class MinStack {
    
        Stack<Pair> stack;
        
        MinStack() {
            stack = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            if(stack.isEmpty()){
                stack.push(new Pair(num,num));
            }
            else{
                Pair p = stack.peek();
                if(p.minSoFar <= num)
                  stack.push(new Pair(num,p.minSoFar));
                else    
                  stack.push(new Pair(num,num));
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(!stack.isEmpty()){
                Pair p = stack.pop();
                return p.num;
            }
            return -1;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(!stack.isEmpty()){
                Pair p =stack.peek();
                return p.num;
            }
            return -1;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(!stack.isEmpty()){
                Pair p = stack.peek();
                return p.minSoFar;
            }
            return -1;
        }
    }
}
