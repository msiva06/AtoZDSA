import java.util.Arrays;

// Best time to buy and sell stock II
public class Problem_36 {
    public static long getMaximumProfit (int n, long[] values) {
       long[][] memo = new long[n+1][2];
    //    memo[n][0] = 0;
    //    memo[n][1] = 0;

    //    for(int i = n-1; i >= 0; i--){
    //        for(int j = 0; j < 2; j++){
    //            long op1 = 0, op2 = 0;
    //            if(j == 0){
    //                op1 = memo[i+1][j];
    //                op2 = memo[i+1][1] - values[i];
    //            }
    //            if(j == 1){
    //                op1 = memo[i+1][j];
    //                op2 = memo[i+1][0] + values[i];
    //            }
    //            memo[i][j] = Math.max(op1,op2);
    //        }
    //    }
    //    return memo[0][0];
       for(int i = 0; i < memo.length; i++)
        Arrays.fill(memo[i],-1L);
       return profit(0,0,values,n,memo);
    }

    public static long profit(int idx,int buy,long[] values,int n,long[][] memo){
        if(idx == n)
            return 0;

        if(memo[idx][buy] != -1L)
            return memo[idx][buy];
        long op1 = 0, op2 = 0;
        if(buy == 0){
            op1 = profit(idx+1,0,values,n,memo);
            op2 = profit(idx+1,1,values,n,memo) - values[idx];
        }
        if(buy == 1){
            op1 = profit(idx+1,1,values,n,memo);
            op2 = profit(idx+1,0,values,n,memo) + values[idx];
        }
        return memo[idx][buy] =  Math.max(op1,op2);
    }
}
