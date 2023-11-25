// Rod cutting problem
public class Problem_24 {
    public static int cutRod(int price[], int n) {
		int m = price.length;
		int[][] memo = new int[m][n+1];
		for(int i = 0; i <= n; i++){
			if(i % 1 == 0)
				memo[0][i] = i * price[0];
		}
		for(int i = 1; i < m; i++){
			for(int j = 0; j <= n; j++){
				int notpick = memo[i-1][j];
				int pick = Integer.MIN_VALUE;
				if(i + 1 <= j)
					pick = price[i] + memo[i][j-(i+1)];

				memo[i][j] = Math.max(pick,notpick);
			}
		}
		return memo[m-1][n];
		// for(int i = 0; i < m;i++)
		// 	Arrays.fill(memo[i],-1);
		// return maxPrice(n-1,price,n,memo);
	}

	public static int maxPrice(int idx,int[] price,int target,int[][] memo){
		if(idx == 0){
			if(target % (idx+1) == 0){
				return (target/(idx+1)) * price[idx];
			}
			return 0;
		}
		if(memo[idx][target] != -1)
			return memo[idx][target];
		int notpick = maxPrice(idx -1,price,target,memo);
		int pick = Integer.MIN_VALUE;
		if(idx+1 <= target){
			pick = price[idx] + maxPrice(idx, price, target-(idx+1),memo);
		}
		
		memo[idx][target] =  Math.max(pick,notpick);
		return memo[idx][target];
	}
}
