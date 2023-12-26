package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

// Stock span
public class Problem_11 {
    public static int[] findStockSpans(int []prices) {
       int[] ans = new int[prices.length];
       Arrays.fill(ans, -1);
       Stack<Integer> monotonic = new Stack<Integer>();
       for(int i = prices.length-1; i >= 0; i--){
           while(!monotonic.isEmpty() && prices[i] >= prices[monotonic.peek()]){
               int span = monotonic.peek() - i;
               ans[monotonic.peek()] = span;
               monotonic.pop();
           }
           monotonic.push(i);
       }
       for(int i = 0; i < ans.length; i++){
           if(ans[i] == -1){
               ans[i] = i+1;
           }
       }
       return ans;
    }
}
