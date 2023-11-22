//Maximum Path sum in the matrix
public class Problem_12 {
    public static int getMaxPathSum(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] memo = new int[n][m];
		for(int j = 0; j < m; j++){
			memo[0][j] = matrix[0][j];
		}
		int up = 0, left = 0, right = 0;
		for(int i = 1; i < n; i++){
			for(int j = 0; j < m; j++){
				
				up = matrix[i][j] + memo[i-1][j];
				
				left = matrix[i][j];
				if(j-1 >= 0)
					left+= memo[i-1][j-1];
				else
					left += (int) Math.pow(-10,9);
				
				right = matrix[i][j];
				if(j+1 < m) 
					right+= memo[i-1][j+1];
				else
					right+= (int) Math.pow(-10,9);
				memo[i][j] = Math.max(Math.max(up,left),right);
			}
		}
		int maxi = Integer.MIN_VALUE;
		for(int j = 0; j < m; j++){
			maxi = Math.max(maxi,memo[n-1][j]);
		}
		return maxi;
		// for(int i = 0; i < n; i++){
		// 	Arrays.fill(memo[i],-1);
		// }
		// int maxi = Integer.MIN_VALUE;
		// for(int i = 0; i < m; i++){
		// 	maxi = Math.max(maxi, maxPath(n-1, i, matrix,memo));
		// }
		// return maxi;
	}

	public static int maxPath(int r,int c,int[][] matrix,int[][] memo){
		if(c < 0 || c >= matrix[0].length)
			return (int)Math.pow(-10,9);

		if(r == 0){
			return matrix[r][c];
		}

		if(memo[r][c] != -1)
			return memo[r][c];
		
		int up = matrix[r][c] + maxPath(r-1,c,matrix,memo);
		int left = matrix[r][c] + maxPath(r-1,c-1,matrix,memo);
		int right = matrix[r][c] + maxPath(r-1, c+1, matrix,memo);
		memo[r][c] =  Math.max(Math.max(up,left),right);
		return memo[r][c];
	}
}
