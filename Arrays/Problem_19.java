package Arrays;

import java.util.HashSet;
import java.util.Set;

// Longest consecutive sequence
public class Problem_19 {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }  
        int maxCount = 1;
        for(Integer s : set){
            int num = s;
            if(set.contains(num-1))
                continue;
            int count = 1;
            while(set.contains(num+1)){
                count++;
                num += 1;
            }    
            maxCount = Math.max(maxCount,count);
        }

        return maxCount;
    }
}
