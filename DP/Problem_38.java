//Best Time to Buy and Sell Stock IV
public class Problem_38 {
    public static int maximumProfit(int[] prices, int n, int k)
    {
        int [][][] memo = new int[n+1][2][k+1];
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                for(int l = 1; l <= k; l++){
                    int op1 = 0, op2 = 0;
                    if(j == 0){
                        op1 = memo[i+1][j][l];
                        op2 = memo[i+1][1][l] - prices[i];
                    }
                    if(j == 1){
                        op1 = memo[i+1][j][l];
                        op2 = memo[i+1][0][l-1] +prices[i];
                    }
                    memo[i][j][l] = Math.max(op1,op2);
                }
            }
        }
        return memo[0][0][k];
        // for(int i = 0; i < memo.length;i++){
        //     for(int j = 0; j < 2; j++){
        //         Arrays.fill(memo[i][j],-1);
        //     }
        // }
        // return profit(0,0,0,prices,k,memo);
    }

    public static int profit(int idx,int buy,int op,int[] prices,int k,int[][][] memo){
        if(op == k)
            return 0;
        if(idx == prices.length)
            return 0;
        if(memo[idx][buy][op] != -1)
            return memo[idx][buy][op];
        int op1 = 0, op2 = 0;
        if(buy == 0){
            op1 = profit(idx+1,0,op,prices,k,memo);
            op2 = (prices[idx] * -1) + profit(idx+1,1,op,prices,k,memo);
        }
        if(buy == 1){
            op1 = profit(idx+1,1,op,prices,k,memo);
            op2 = prices[idx] + profit(idx+1,0,op+1,prices,k,memo);
        }
        int maxProfit = Math.max(op1,op2);
        return memo[idx][buy][op] = maxProfit;
    }
}
}
