// Partitions with given difference
public class Problem_18 {
    public static int countPartitions(int n, int d, int[] arr) {
		int totsum = 0;
		for(int a : arr)
			totsum += a;
		if(totsum - d < 0)
			return 0;
		if((totsum - d) %2 != 0)
			return 0;
		int target = (totsum - d) / 2;
		
		return findPart(arr,target,n);


	}

	public static int findPart(int[] arr,int target,int n){
		int[][] dp = new int[n][target+1];
		int mod = (int) 1e9+7;
		for(int i = 0; i < n; i++){
			for(int k = 0; k <= target; k++){
				if(i == 0 && k == 0 && arr[i] == 0){
					dp[i][k] = 2;
					continue;
				}	
				else if(i == 0 && (k == 0 || arr[i] == k)){
					dp[i][k] = 1;
					continue;
				}
					
				else if(i > 0){
					int notpick = dp[i-1][k];
					int pick = 0;
					if(arr[i] <= k)
						pick = dp[i-1][k-arr[i]];
					dp[i][k] = (pick + notpick) % mod;
				}

			}
		}
		return dp[n-1][target];

	}
}
