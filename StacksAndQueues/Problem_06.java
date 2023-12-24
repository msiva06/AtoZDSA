package StacksAndQueues;

import java.util.Stack;

// Next greater element
public class Problem_06 {
    public static int[] nextGreaterElement(int[] arr, int n) {
        int[] nge = new int[n];
        Stack<Integer> stack= new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if(!stack.isEmpty()){
                nge[i] = stack.peek();
            }
            else{
                nge[i] = -1;
            }
            stack.push(arr[i]);
        }
         return nge;
    }
}
