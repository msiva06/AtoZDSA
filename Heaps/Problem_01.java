package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Kth Smallest and Largest Element of Array
public class Problem_01 {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> desc = new PriorityQueue<>((a,b) -> b - a);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(Integer a : arr){
			pq.add(a);
			desc.add(a);
		}
		int smallest = -1, largest = -1;
		while(k > 0){
			smallest = pq.poll();
			largest = desc.poll();
			k--;
		}
		res.addAll(Arrays.asList(smallest,largest));
		return res;
	}
}
