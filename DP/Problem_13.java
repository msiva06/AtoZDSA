// Chocolate Pickup
public class Problem_13 {
    public static int maximumChocolates(int r, int c, int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][][] memo = new int[n][m][m];
		for(int j1 = 0; j1 < m; j1++){
			for(int j2= 0;j2 < m;j2++){
				if(j1 == j2){
					memo[n-1][j1][j2] = grid[n-1][j1];
				}
				else
					memo[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
			}
		}

		for(int r1 = n-2; r1 >= 0; r1--){
			for(int c1 = 0; c1 < m; c1++){
				for(int c2= 0;c2 < m;c2++){
					int maxi = Integer.MIN_VALUE;
					for(int j1 = -1; j1 <= 1; j1++){
						for(int j2 = -1; j2 <= 1; j2++){
							int ans;
							if(c1 == c2){
								ans = grid[r1][c1] ;
							}
							else{
								ans = grid[r1][c1] + grid[r1][c2];
							}
							if(c1 + j1 >= 0 && c1 + j1 < m && c2 + j2 >= 0 && c2 + j2 < m)
								ans += memo[r1+1][c1+j1][c2+j2];
					maxi = Math.max(maxi,ans);
				}
			}	
			memo[r1][c1][c2] = maxi;
				}
			}
		}
		return memo[0][0][m-1];
		// for(int[][] row : memo){
		// 	for(int r1[]:row){
		// 		Arrays.fill(r1,-1);
		// 	}
				
		// }		
		// return maxChocolates(0, 0, m-1, grid,memo);
	}

	public static int maxChocolates(int r, int c1, int c2,int[][] grid,int[][][] memo){
		if(c1 < 0 || c1 >= grid[0].length || c2 < 0  || c2 >= grid[0].length)
			return (int)Math.pow(-10,9);

		if(r == grid.length-1){
			if(c1 == c2){
				return grid[r][c1];
			}
			else{
				return grid[r][c1] + grid[r][c2];
			}
		}

		if(memo[r][c1][c2] != -1)
			return memo[r][c1][c2];
		int maxi = Integer.MIN_VALUE;
		for(int j1 = -1; j1 <= 1; j1++){
			for(int j2 = -1; j2 <= 1; j2++){
				int ans;
				if(c1 == c2){
						ans = grid[r][c1] + maxChocolates(r+1, c1+j1, c2+j2, grid,memo);
					}
					else{
						ans = grid[r][c1] + grid[r][c2] + maxChocolates(r+1, c1+j1, c2+j2, grid,memo);
					}
				maxi = Math.max(maxi,ans);
			}
			
		}	
		memo[r][c1][c2] = maxi;
		return memo[r][c1][c2];
		

	}
}
