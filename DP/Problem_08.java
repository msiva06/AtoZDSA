// Unique paths
public class Problem_08 {
    public static int uniquePaths(int m, int n) {
		//int[][] memo = new int[m][n];
		int[] prev = new int[m];
		// for(int i = 0; i < memo.length; i++){
		// 	Arrays.fill(memo[i],-1);
		// }
		for(int i = 0; i < m; i++){
			int[] temp = new int[n];
			for(int j = 0; j < n; j++){
				if(i == 0 && j == 0){
					temp[j] = 1;
					continue;
				}
				int up = 0, left = 0;
				if(i >= 1)
					up = prev[j];
				if(j >= 1)
					left = temp[j-1];
				temp[j] = up + left;
				
				
			}
			prev = temp;
		}
		return prev[n-1];
		//return pathCount(m-1,n-1,memo);
	}

	public static int pathCount(int r,int c,int[][] memo){
		if(r == 0 && c == 0){
			return 1;
		}
		if(r < 0 || c < 0)
			return 0;

		if(memo[r][c] != -1)
			return memo[r][c];

		int upCount = pathCount(r-1,c,memo);
		int leftCount = pathCount(r,c-1,memo);
		memo[r][c] =  upCount + leftCount;
		return memo[r][c];
		
	}
}
