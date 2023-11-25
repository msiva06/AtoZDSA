// Print Longest common subsequence
public class Problem_26 {
    public static String findLCS(int n, int m, String s1, String s2){
        n = s1.length();
        m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int length = dp[n][m];
        int i = n, j = m;
        int idx = length -1;
        String str = "";
        for(int k = 1; k <= length; k++){
            str += "$";
        }
        StringBuilder sb = new StringBuilder(str);
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                sb.setCharAt(idx,s1.charAt(i-1));
                idx--;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else
                j--;
        }
        //System.out.println(sb);
        return String.valueOf(sb);
    }
}
