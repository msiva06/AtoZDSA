package Arrays;

import java.util.HashMap;
import java.util.Map;

// Longest substring without repeating characters
public class Problem_12 {
    public static int uniqueSubstrings(String input) 
    {
		Map<Character,Integer> map = new HashMap<>();
		int left = 0, right = 0;
		int len = 0;
		int maxLen = Integer.MIN_VALUE;
		while(right < input.length()){
			char c = input.charAt(right);
			if(map.containsKey(c)){
				left = Math.max(map.get(c)+1,left);	
			}
			len = right - left + 1;
			maxLen = Math.max(maxLen,len);	
			map.put(c,right);
			right++;
		}
		return maxLen;
	}
}
