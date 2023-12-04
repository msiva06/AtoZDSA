// Buy and sell stock III
public class Problem_37 {
    public static int maxProfit(int []prices) {
        int n = prices.length;
        int[][][] memo = new int[n+1][2][3];
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < 2;j++){
                for(int k = 1; k <= 2; k++){
                    int op1 = 0, op2 = 0;
                    if(j == 0){
                        op1 = memo[i+1][j][k];
                        op2 = memo[i+1][1][k] - prices[i];
                    }
                    if(j == 1){
                        op1 = memo[i+1][j][k];
                        op2 = memo[i+1][0][k-1] + prices[i];
                    }
                    memo[i][j][k] = Math.max(op1,op2);
                }
            }
        }
        return memo[0][0][2];
        // for(int i = 0; i < memo.length; i++){
        //     for(int j = 0; j < 2; j++){
        //          Arrays.fill(memo[i][j],-1);
        //     }
               
        // }
        // return profit(0,0,0,prices,memo);
    }
    public static int profit(int idx,int buy,int op,int[] prices,int[][][] memo){
        if(op == 2)
            return 0;
        if(idx == prices.length)
            return 0;
        if(memo[idx][buy][op] != -1)
            return memo[idx][buy][op];
        int op1 = 0, op2 = 0;
        if(buy == 0){
            op1 = profit(idx+1,0,op,prices,memo);
            op2 = (prices[idx] * -1) + profit(idx+1,1,op,prices,memo);
        }
        if(buy == 1){
            op1 = profit(idx+1,1,op,prices,memo);
            op2 = prices[idx] + profit(idx+1,0,op+1,prices,memo);
        }
        int maxProfit = Math.max(op1,op2);
        return memo[idx][buy][op] = maxProfit;
    }
}
