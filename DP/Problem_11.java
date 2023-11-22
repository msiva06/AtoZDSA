// Triangle
public class Problem_11 {
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] memo = new int[n][n];

        for(int j = 0; j < triangle[n-1].length; j++){
            memo[n-1][j] = triangle[n-1][j];
        }
        for(int i = n-2;  i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle[i][j] + memo[i+1][j];
                int diag = triangle[i][j] + memo[i+1][j+1];
                memo[i][j] = Math.min(down,diag);
            }
        }
        return memo[0][0];
    //     for(int i = 0; i < n; i++){
    //         Arrays.fill(memo[i],-1);
    //     }
    //    return minPath(0,0,triangle,memo);
    }

    public static int minPath(int r, int c, int[][] triangle,int[][] memo){
        int n = triangle.length;
        int m = triangle[0].length;
        if(r == n-1){
            return triangle[r][c];
        }

        if(memo[r][c] != -1)
            return memo[r][c];

        int down = triangle[r][c] + minPath(r+1,c,triangle,memo);
        int diag = triangle[r][c] + minPath(r+1,c+1,triangle,memo);
        memo[r][c] =  Math.min(down,diag);
        return memo[r][c];
    }
}
