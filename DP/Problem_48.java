import java.util.Arrays;

// Matrix Chain multiplication
public class Problem_48 {
    public static int mcm(int[] p){
		
	/* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	*/
		int n = p.length;
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(dp[i],-1);
		}

		for(int i = 1; i < n; i++){
			dp[i][i] = 0;
		}
		
		for(int i = n-1; i >= 1;i--){
			for(int j = i+1; j < n; j++){
				int mini = Integer.MAX_VALUE;
				for(int k = i; k < j; k++){
					int steps = p[i-1] * p[k] * p[j] + dp[i][k] + dp[k+1][j];
					mini = Math.min(mini,steps);
				}
				dp[i][j] = mini;
			}
		}
		return dp[1][n-1];
		// for(int i = 0; i < n; i++)
		// 	Arrays.fill(memo[i],-1);
		// return multiply(1,n-1,p,memo);
	}

	public static int multiply(int i,int j,int[] p,int[][] memo){
		if(i == j)
			return 0;
		int mini = Integer.MAX_VALUE;
		for(int k = i; k < j; k++){
			int steps = p[i-1] * p[k] *p[j] + multiply(i,k,p,memo) + multiply(k+1, j, p,memo);
			mini = Math.min(mini,steps);
		}
		return memo[i][j] = mini;
	}
}
