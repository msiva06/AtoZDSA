// Count subsets with sum K
public class Problem_17 {
    public static int findWays(int num[], int tar) {
        int mod = (int)1e9+7;
       int n = num.length;
       int[][] dp = new int[n][tar+1];
       for(int i = 0; i < n;i++){
           dp[i][0] = 1;
       }
       if(num[0] <= tar)
           dp[0][num[0]] = 1;
       for(int i = 1; i <n;i++){
           for(int k = 1; k <= tar;k++){
               int notpick = dp[i-1][k];
               int pick = 0;
               if(num[i] <= k)
                   pick = dp[i-1][k - num[i]];
               dp[i][k] = (pick + notpick) % mod;
           }
       }
       return dp[n-1][tar];
       
   }
}
