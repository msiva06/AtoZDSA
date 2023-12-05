import java.util.Arrays;

// Longest Increasing subsequence
public class Problem_42 {
    public static int longestIncreasingSubsequence(int arr[]) {
		// int n = arr.length;
		// int[][] memo = new int[n+1][n+1];
		// for(int i = n-1; i >= 0; i--){
		// 	for(int prev = i-1; prev >= -1; prev--){
		// 		int notpick = memo[i+1][prev+1];
		// 		int pick = 0;
		// 		if(prev == -1 || arr[i] > arr[prev])
		// 			pick = 1 + memo[i+1][i+1];
		// 		memo[i][prev+1] = Math.max(pick,notpick);
		// 	}
		// }
		// return memo[0][0];

		// **************************************
		int n = arr.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp,1);
        }
        int maxi = 1;
		int largeIdx = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                maxi = Math.max(maxi,dp[i]);
            }
        }
        return maxi;

		// for(int i = 0; i < memo.length; i++)
		// 	Arrays.fill(memo[i],-1);
		// return longest(0,-1,arr,memo);
	}

	public static int longest(int idx,int prev,int[] arr,int[][] memo){
		if(idx == arr.length){
			return 0;
		}
		if(memo[idx][prev+1] != -1)
			return memo[idx][prev+1];
		int notpick = longest(idx+1,prev,arr,memo);
		int pick = 0;
		if(prev == -1 || arr[idx] > arr[prev]){
			pick = 1 + longest(idx+1,idx,arr,memo);
		}
		return memo[idx][prev+1] =  Math.max(pick,notpick);
	}
}
