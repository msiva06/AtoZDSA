import java.util.ArrayList;

// Unique paths II
public class Problem_09 {
   static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] memo = new int[n][m];
        int mod = (int)1e9+7;
        // for(int i = 0; i < memo.length; i++){
        //     Arrays.fill(memo[i],-1);
        // }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    memo[i][j] = 1;
                    continue;
                }
                if(i >= 0 && j >= 0 && mat.get(i).get(j) == -1){
                    memo[i][j] = 0;
                    continue;
                }
                int up = 0, left = 0;
                if(i >= 1)
                    up = memo[i-1][j];
                if(j >= 1)
                    left = memo[i][j-1];
                memo[i][j] = (up + left) % mod;

            }
        }
        return memo[n-1][m-1] % mod;
        //return findCount(n-1,m-1,mat,memo);
    }

    public static int findCount(int r, int c,ArrayList<ArrayList<Integer>> mat,int[][] memo){
        int mod = 1e9 + 7;
        if(r >= 0 && c >= 0 && mat.get(r).get(c) == -1)
            return 0;
        if(r == 0 && c == 0)
            return 1;
        if(r < 0 || c < 0)
            return 0;
        
        if(memo[r][c] != -1)
            return memo[r][c];
        int up = findCount(r-1,c,mat,memo);
        int left = findCount(r,c-1,mat,memo);
        memo[r][c] = (up + left) % mod;
        return memo[r][c];
    } 
}
