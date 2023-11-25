// Longest common subsequence
public class Problem_25 {
    public static int lcs(String s, String t) {
        int[][] memo = new int[s.length()+1][t.length()+1];
        for(int i = 0; i <= s.length(); i++){
            memo[i][0] = 0;
        }
        for(int j = 0; j <= t.length(); j++){
            memo[0][j] = 0;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    memo[i][j] = 1 + memo[i-1][j-1];
                }
                else{
                    memo[i][j] = Math.max(memo[i][j-1],memo[i-1][j]);
                }
            }
        }
        return memo[s.length()][t.length()];
        // for(int i = 0; i <s.length(); i++){
        //     Arrays.fill(memo[i],-1);
        // }
		// return findMaxLen(s.length()-1,t.length()-1,s,t,memo);
    }

    public static int findMaxLen(int id1, int id2,String s,String t,int[][] memo){
        if(id1 < 0 || id2 < 0)
            return 0;
        if(memo[id1][id2] != -1)
            return memo[id1][id2];
        if(s.charAt(id1) == t.charAt(id2))
            memo[id1][id2] =  1 + findMaxLen(id1-1, id2-1, s, t,memo);
        else
            memo[id1][id2] =Math.max(findMaxLen(id1, id2-1, s, t,memo), findMaxLen(id1-1, id2, s, t,memo));
        return memo[id1][id2];
    }
}
