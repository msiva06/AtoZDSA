package DP;

import java.util.ArrayList;

// Max Increasing sum subsequence
public class Problem_57 {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int[] dp = new int[n];
        for(int i = 0; i < rack.size(); i++){
            dp[i] = rack.get(i);
        }

        for(int i = 1; i < rack.size(); i++){
            for(int j = 0; j < i; j++){
                if(rack.get(i) > rack.get(j) && dp[i] < dp[j] + rack.get(i)){
                    dp[i] = dp[j] + rack.get(i);
                }
            }
        }

        int maxi = 0;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}
