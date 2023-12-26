package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

// Maximum of minimum for every window size
public class Problem_12 {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] res = new int[n];
        Arrays.fill(res,Integer.MIN_VALUE);
        int[] next = getNextSmaller(a);
        int[] prev = getPrevSmaller(a);
        for(int i = 0; i < a.length; i++){
            int len = next[i] - prev[i] - 1;
            res[len-1] = Math.max(res[len-1],a[i]);
        }

        for(int i = n-2; i >= 0; i--){
            res[i] = Math.max(res[i],res[i+1]);
        }
        return res;


    }

    public static int[] getNextSmaller(int[] a){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[a.length];
        int n = a.length;
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i])
                stack.pop();
            if(stack.isEmpty())
                res[i] = n;
            else
                res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int[] getPrevSmaller(int[] a){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[a.length];
        int n = a.length;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                res[i] = -1;
            else
                res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }
}
