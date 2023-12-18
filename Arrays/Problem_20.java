package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Longest subarray with zero sum
public class Problem_20 {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		int sum = 0;
		int maxLong = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < arr.size();i++){
				sum += arr.get(i);
				if(sum == 0)
					maxLong = i+1;
				
				else {
					if(map.containsKey(sum))
						maxLong = Math.max(maxLong,i-map.get(sum));
					else
						map.put(sum,i);

				}
				
		}
		return maxLong;
	}
}
