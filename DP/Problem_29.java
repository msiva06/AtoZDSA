// Minimum insertions to make string palindrome
public class Problem_29 {
    public static int minInsertion(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        int n = str.length();
        int m = rev.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m;j++){
                if(str.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else    
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int totLen = str.length();
        int palLen = dp[n][m];
        return totLen - palLen;
    }
}
