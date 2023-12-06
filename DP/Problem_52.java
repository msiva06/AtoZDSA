import java.util.ArrayList;
import java.util.List;

// Burst Balloons
public class Problem_52 {
    public static int burstBalloons(int []arr){
        int n = arr.length;
        List<Integer> arrL = new ArrayList<>();
        arrL.add(1);
        for(int a : arr)
            arrL.add(a);
        arrL.add(1);
        int[][] dp = new int[n+2][n+2];
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j)
                    continue;
                int maxi = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++){
                    int cost = arrL.get(i-1) * arrL.get(k) * arrL.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    maxi = Math.max(maxi,cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
        // int[][] memo = new int[n+2][n+2];
        // for(int i = 0; i < memo.length; i++)
        //     Arrays.fill(memo[i],-1);
        // return burst(1,n,arrL,memo);
    }

    public static int burst(int i,int j, List<Integer> arrL,int[][] memo){
        if(i > j)
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int cost = arrL.get(i-1) * arrL.get(k) * arrL.get(j+1) + burst(i,k-1,arrL,memo) + burst(k+1,j,arrL,memo);
            maxi = Math.max(maxi,cost);
        }
        return memo[i][j] = maxi;
    }
}
