package DP;

// Count numbers with unique digits
public class Problem_56 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[10];
        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 91;
        for(int i = 3; i < 9; i++){
            int count = 9;
            int ans = 9;
            for(int j = 2; j <= i; j++){
                ans *= count;
                count--;
            }
            dp[i] = ans + dp[i-1];
        }
        return dp[n];
    }
}
