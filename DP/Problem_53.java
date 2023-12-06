// Boolean Evaluation
public class Problem_53 {
    public static int evaluateExp(String exp) {
        int n  =exp.length();
        // Long[][][] dp = new Long[n][n][2];
        
        // return (int) expr(0,n-1,1,exp,dp);
        int mod = 1000000007;
        long[][][] dp = new long[n][n][2];
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(i > j)
                        continue;
                for(int l = 0; l < 2; l++){
                    
                    if(i == j){
                        if(l == 1){
                            dp[i][j][l] = exp.charAt(i) == 'T' ? 1: 0;
                        }
                        else{
                            dp[i][j][l] = exp.charAt(i) == 'F' ? 1:0;
                        }
                        continue;
                    }
                    long ways = 0;
                    for(int k = i+1; k <= j-1; k+=2){
                        long lT = dp[i][k-1][1];
                        long rT = dp[k+1][j][1];
                        long lF = dp[i][k-1][0];
                        long rF = dp[k+1][j][0];
                        if(exp.charAt(k) == '&'){
                            if(l == 1){
                                ways = (ways + (lT * rT) % mod) % mod;
                            }
                            else{
                                ways = (ways + (lT * rF) % mod +(lF * rT) % mod + (lF * rF) % mod) % mod;
                            }
                        }
                        else if(exp.charAt(k) == '|'){
                            if(l == 1){
                                ways = (ways + (lT * rF) % mod +(lF * rT) % mod + (lT * rT) % mod) % mod;
                            }
                            else{
                                ways = (ways + (lF * rF) % mod) % mod;
                            }
                        }
                        else if(exp.charAt(k) == '^'){
                            if(l == 1){
                                ways = (ways + (lT * rF) % mod +(lF * rT) % mod) % mod;
                            }
                            else{
                                ways = (ways + (lT * rT) % mod+ (lF * rF) % mod) % mod;
                            }
                        }
                    }
                    dp[i][j][l] = ways;
                }

            }
        }
        return (int) dp[0][n-1][1];
    }

    public static long expr(int i, int j ,int isTrue,String exp,Long[][][] dp){
        int mod = 1000000007;
        if(i > j)
            return 0;
        if(i == j){
            if(isTrue == 1)
                return exp.charAt(i) == 'T'? 1 : 0;
            else
                return exp.charAt(i) == 'F'? 1 : 0;
            
        }
        if(dp[i][j][isTrue] != null)
            return dp[i][j][isTrue];
        
        long ways = 0;
        for(int k = i+1; k <= j-1; k+=2){
            long lT = expr(i,k-1,1,exp,dp);
            long rT = expr(k+1,j,1,exp,dp);
            long lF = expr(i,k-1,0,exp,dp);
            long rF = expr(k+1,j,0,exp,dp);
            if(exp.charAt(k) == '&'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT) % mod) % mod;
                }
                else{
                    ways = (ways + (lT * rF) % mod +(lF * rT) % mod + (lF * rF) % mod) % mod;
                }
            }
            else if(exp.charAt(k) == '|'){
                if(isTrue == 1){
                    ways = (ways + (lT * rF) % mod +(lF * rT) % mod + (lT * rT) % mod) % mod;
                }
                else{
                    ways = (ways + (lF * rF) % mod) % mod;
                }
            }
            else if(exp.charAt(k) == '^'){
                if(isTrue == 1){
                    ways = (ways + (lT * rF) % mod +(lF * rT) % mod) % mod;
                }
                else{
                    ways = (ways + (lT * rT) % mod+ (lF * rF) % mod) % mod;
                }
            }
        }
        dp[i][j][isTrue] = ways;
        return ways;
    }
}
