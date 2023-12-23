package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Merge K sorted arrays
public class Problem_03 {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
		for(int i = 0; i < kArrays.size();i++){
			minHeap.add(new int[]{kArrays.get(i).get(0),i,0});
		}

		ArrayList<Integer> res = new ArrayList<>();
		while(!minHeap.isEmpty()){
			int[] popped = minHeap.poll();
			int val = popped[0];
			int arrIndex = popped[1];
			int elemIndex = popped[2];
			res.add(val);
			int size = kArrays.get(arrIndex).size();
			elemIndex += 1;
			if(elemIndex == size)
				continue;
			minHeap.add(new int[]{kArrays.get(arrIndex).get(elemIndex),arrIndex,elemIndex});
		}
		return res;
    }	
}
