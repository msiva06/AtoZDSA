// Edit distance
public class Problem_33 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // if(word2.length() == 0)
        //     return word1.length();
        // if(word1.length() == 0)
        //     return word2.length();
        // if(word1.equals(word2))
        //     return 0;
        int[][] memo = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            memo[i][0] = i;
        }
        for(int i = 0; i <= m; i++){
            memo[0][i] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1];
                }
                else{
                    int add = 1 + memo[i][j-1];
                    int delete = 1 + memo[i-1][j];
                    int replace = 1 + memo[i-1][j-1];
                    memo[i][j] = Math.min(Math.min(add,delete),replace); 
                }
            }
        }
        return memo[n][m];
        // for(int i =0; i<= n; i++)
        //     Arrays.fill(memo[i],-1);
        // return dist(n-1,m-1,word1,word2,memo);
    }

    public int dist (int id1,int id2,String s1,String s2,int[][] memo){
        if(id2 < 0)
            return id1 + 1;
        if(id1 < 0)
            return id2 + 1;
        if(memo[id1][id2] != -1)
            return memo[id1][id2];
        if(s1.charAt(id1) == s2.charAt(id2)){
            memo[id1][id2]= dist(id1-1,id2-1,s1,s2,memo);
        } 
        else{
            int add = 1 + dist(id1,id2-1,s1,s2,memo);
            int delete = 1 + dist(id1-1,id2,s1,s2,memo);
            int replace = 1 + dist(id1-1,id2-1,s1,s2,memo);
            memo[id1][id2]= Math.min(Math.min(add,delete),replace);
        }
        return memo[id1][id2];
            
        
        
    }
}
