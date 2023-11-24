// Partition Equal subset sum
public class Problem_15 {
    public static boolean canPartition(int[] arr, int n) {
		int totsum = 0;
		for(int a : arr)
			totsum += a;
		if(totsum % 2 != 0)
			return false;
		int target = totsum/2;
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
		return dp[n-1][target];
	}
}
