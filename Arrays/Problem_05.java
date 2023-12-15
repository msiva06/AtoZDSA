package Arrays;

// Maximum subarray sum
public class Problem_05 {
    public static long maxSubarraySum(int[] arr, int n) {
		int right = 0;
		long sum = 0;
		long maxSum = Long.MIN_VALUE;
		while(right < n){
			sum += arr[right];
			
			if(sum < 0){
				sum = 0;
			}
			maxSum = Math.max(sum,maxSum);
			right++;
		}
		return maxSum;
	}
}
