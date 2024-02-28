package Arrays.Easy;

// Longest subarray with sum K
public class Problem_08 {
    public static int longestSubarrayWithSumK(int []a, long k) {
        int start = 0, end = -1, maxLen = 0;
        long sum = 0;
        while(start < a.length){
            while(end+1 < a.length && sum + a[end+1] <= k){
                sum += a[end+1];
                end++;
                if(sum == k){
                    maxLen = Math.max(maxLen, end - start+1);
                }
                
            }
            sum -= a[start];
            start+=1;
        }
         return maxLen;
    }
}
