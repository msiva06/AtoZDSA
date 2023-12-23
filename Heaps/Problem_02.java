package Heaps;

import java.util.PriorityQueue;

// Median in a stream
public class Problem_02 {
    public static int[] findMedian(int[] arr, int n) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      int[] res = new int[n];
      for(int i = 0; i < arr.length; i++){
          if(maxHeap.isEmpty() || maxHeap.peek() > arr[i])
            maxHeap.add(arr[i]);
          else  
            minHeap.add(arr[i]);
          if(maxHeap.size() > minHeap.size()+1){
              minHeap.add(maxHeap.poll());
          }
          if(minHeap.size() > maxHeap.size()+1){
              maxHeap.add(minHeap.poll());
          }
          if(maxHeap.size() == minHeap.size()){
              res[i] = (maxHeap.peek() + minHeap.peek())/2;
          }
          else{
              if(maxHeap.size() > minHeap.size()){
                  res[i] = maxHeap.peek();
              }
              else{
                  res[i] = minHeap.peek();
              }
          }
      }
      return res;
      
    }
}
