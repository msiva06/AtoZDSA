package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

// Sliding window maximum
public class Problem_10 {
    public static int[] maxSlidingWindow(int[] arr, int n, int k) {
        int[] res = new int[arr.length - k +1];
		Deque<Integer> deq = new ArrayDeque();
		int ri = 0;
		for(int i = 0; i < arr.length; i++){
			if(!deq.isEmpty() && deq.peek() == i - k){
				deq.poll();
			}
			while(!deq.isEmpty() && arr[deq.peekLast()] < arr[i])
				deq.pollLast();
			deq.offer(i);

			if(i >= k-1){
				res[ri++] = arr[deq.peek()];
			}
		}
		return res;
	}
}
