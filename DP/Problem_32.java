// Distinct subsequences
public class Problem_32 {
    static int mod = (int) 1e9+7;
    public static int distinctSubsequences(String str, String sub) {
        
        int n = str.length();
        int m = sub.length();
        int[][] memo = new int[n+1][m+1];
        for(int i = 0; i <= n; i++)
            memo[i][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str.charAt(i-1) == sub.charAt(j-1))
                    memo[i][j] = (memo[i-1][j-1] + memo[i-1][j]) % mod;
                else   
                    memo[i][j] = memo[i-1][j];
            }
        }
        return memo[n][m];
        // for(int i = 0; i < n; i++)
        //     Arrays.fill(memo[i],-1);
        // return dist(n-1,m-1,str,sub,memo) % mod;
    }

    public static int dist(int id1,int id2,String s1, String s2,int[][] memo){
        if(id2 < 0)
            return 1;
        if(id1 < 0)
            return 0;
        if(memo[id1][id2] != -1)
            return memo[id1][id2];

        if(s1.charAt(id1) == s2.charAt(id2)){
            memo[id1][id2] =  (dist(id1 - 1,id2-1,s1,s2,memo) + dist(id1-1,id2,s1,s2,memo)) % mod;
        }
        else
            memo[id1][id2] = dist(id1-1,id2,s1,s2,memo);
        return memo[id1][id2] % mod;
    }
}
