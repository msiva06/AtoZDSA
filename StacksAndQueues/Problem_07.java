package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

// Nearest smaller element
public class Problem_07 {
     public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> prev = new ArrayList<Integer>(n);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < n; i++){
            while(!stack.isEmpty() && stack.peek() > A.get(i))
                stack.pop();
            if(!stack.isEmpty()){
                prev.add(stack.peek());
            }
            else{
                prev.add(-1);
            }
            stack.push(A.get(i));
        }
        return prev;
    }
}
