package AtoZDSA.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Fruits and Baskets
public class Problem_01 {
    public static int findMaxFruits(int []arr, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0, right = 0,maxLen = Integer.MIN_VALUE;
        while(right < n){
            if(map.containsKey(arr[right]) || map.size() < 2){
                map.put(arr[right],map.getOrDefault(arr[right], 0)+1);
                maxLen = Math.max(maxLen, right - left+1);
                right++;
            }
            else{
                int freq = map.get(arr[left]) - 1;
                if(freq == 0){
                    map.remove(arr[left]);
                }
                else{
                    map.put(arr[left],freq);
    
                }
                left++;
            }
        }
        return maxLen;
    }
}
