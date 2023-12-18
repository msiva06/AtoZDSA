package Arrays;

import java.util.Arrays;

// Unique paths
public class Problem_15 {
    public static int uniquePaths(int m, int n) {
		int[][] memo = new int[m][n];
		for(int i = 0; i < m; i++)
			Arrays.fill(memo[i],-1);
		return path(m-1,n-1,memo);
	}

	public static int path(int i, int j,int[][] memo){
		if(i < 0 || j < 0)
			return 0;
		if(i == 0 && j == 0){
			return 1;
		}
		if(memo[i][j] != -1)
			return memo[i][j];
		int up = path(i-1,j,memo);
		int left = path(i,j-1,memo);
		return memo[i][j] = up + left;
	}
}
