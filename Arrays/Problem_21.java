package Arrays;

import java.util.HashMap;
import java.util.Map;

// Subarrays with xor K
public class Problem_21 {
     public static int subarraysWithSumK(int []a, int b) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        
        int xor = 0;
        for(int i = 0; i < a.length; i++ ){
            xor ^= a[i];
            int target = xor ^ b;
            if(map.containsKey(target)){
                count += map.get(target);
            }
                if(map.containsKey(xor)){
                    map.put(xor,map.get(xor)+1);
                }
                else{
                    map.put(xor,1);
                }
        }
        return count;
    }
}
