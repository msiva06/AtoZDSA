// Minimum path sum
public class Problem_10 {
    public static int minSumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int memo[][] = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     Arrays.fill(memo[i],-1);
        // }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                {
                    memo[i][j] = grid[i][j];
                    continue;
                }
                int up = 0, left = 0;
                if(i >= 1){
                    up = grid[i][j] + memo[i-1][j];
                }
                else{
                    up += (int)Math.pow(10,9);
                }
                if(j >= 1){
                    left = grid[i][j] + memo[i][j-1];
                }
                else{
                    left += (int)Math.pow(10,9);
                }
                memo[i][j] = Math.min(up,left);
            }
        }
        return memo[m-1][n-1];
        //return minSum(m-1,n-1,grid,memo);
    }

    public static int minSum(int r, int c,int[][] grid,int[][] memo){
        if(r == 0 && c == 0){
            return grid[r][c];
        }
        if(r < 0 || c < 0)
            return (int)Math.pow(10,9);

        if(memo[r][c] != -1)
            return memo[r][c];

       
        int  up = grid[r][c] + minSum(r-1,c,grid,memo);
       int left = grid[r][c] + minSum(r,c-1,grid,memo);
        memo[r][c] =  Math.min(up,left);
        return memo[r][c];
        
    }
}
