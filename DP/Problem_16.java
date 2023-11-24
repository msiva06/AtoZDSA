// Array partition with minimum difference
public class Problem_16 {
    public static int minSubsetSumDifference(int []arr, int n) {  
        int totsum = 0;
		for(int a : arr)
			totsum += a;
		int target = totsum;
        boolean[][] dp = new boolean[n][target+1];  
        for(int i = 0; i < n; i++){
			dp[i][0] = true;
		}
		if(arr[0] <= target)
			dp[0][arr[0]] = true;
		for(int i = 1; i < n; i++){
			for(int k = 1; k <= target;k++){
				boolean notpick = dp[i-1][k];
				boolean pick = false;
				if(arr[i] <= k)
					pick = dp[i-1][k-arr[i]];
				dp[i][k] = pick || notpick;
			}
		}
        int mini = Integer.MAX_VALUE;
        for(int k = 0; k <= target;k++){

            if(dp[n-1][k])
            {
                int s1 = k;
                int s2 = target - k;
                mini = Math.min(mini,Math.abs(s1-s2));
            }
        }
        return mini;
    }
}
