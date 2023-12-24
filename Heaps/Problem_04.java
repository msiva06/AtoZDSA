package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// K most frequent elements
public class Problem_04 {
    public static int[] KMostFrequent(int n, int k, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        int[] res = new int[k];
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            pq.add(m);
        }
        int i = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> popped = pq.poll();
            res[i++] = popped.getKey();
            if(i == k)
                break;
        }
        return res;
    }
}
