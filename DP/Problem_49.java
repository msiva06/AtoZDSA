import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Min cost to cut a stick
public class Problem_49 {
    public int minCost(int n, int[] cuts) {
        List<Integer> cutL = new ArrayList<>();
        cutL.add(0);
        cutL.add(n);
        for(int c : cuts){
            cutL.add(c);
        }
        Collections.sort(cutL);
        int c = cuts.length;
        int[][] dp = new int[c+2][c + 2];
        for(int i = c; i >= 1; i--){
            for(int j = 1; j <= c; j++){
                if(i > j)
                    continue;
                int mini = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    int cutOp = cutL.get(j+1) - cutL.get(i-1) + dp[i][k-1] + dp[k+1][j];
                    mini = Math.min(mini,cutOp);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
        // int[][] memo = new int[c+1][c+1];
        // for(int i = 0; i < memo.length; i++)
        //     Arrays.fill(memo[i],-1);
        // return cost(1,c,cutL,memo);

    }

    public int cost(int i,int j,List<Integer> cutL,int[][] memo){
        if(i > j)
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];
        int mini = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++){
            int cutsOp = cutL.get(j+1) - cutL.get(i-1) + cost(i,k-1,cutL,memo) +cost(k+1,j,cutL,memo);
            mini = Math.min(mini,cutsOp);
        }
        return memo[i][j] = mini;
    }
}
