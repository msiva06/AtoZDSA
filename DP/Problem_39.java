//Best Time to Buy and Sell Stock with Cooldown
public class Problem_39 {
    public static int stockProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n+2][2];
        memo[n][0] = 0;
        memo[n][1] = 0;
        for(int i = n-1;i >= 0;i--){
            for(int j = 0; j < 2; j++){
                int op1 = 0, op2 = 0;
                if(j == 0){
                    op1 = memo[i+1][j];
                    op2 = memo[i+1][1] - prices[i];
                }
                if(j == 1){
                    op1 = memo[i+1][j];
                    op2 = memo[i+2][0] + prices[i];
                }
                memo[i][j] = Math.max(op1,op2);
            }
        }
        return memo[0][0];
        // for(int i = 0; i < memo.length; i++)
        //     Arrays.fill(memo[i],-1);
        // return profit(0,0,prices,memo);
    }

    public static int profit(int idx,int buy,int[] prices,int[][] memo){
        if(idx >= prices.length)
            return 0;
        if(memo[idx][buy] != -1)
            return memo[idx][buy];
        int op1 = 0, op2 =0;
        if(buy == 0){
            op1 = profit(idx+1,0,prices,memo);
            op2 = profit(idx+1,1,prices,memo) - prices[idx];
        }
        else{
            op1 = profit(idx+1,1,prices,memo);
            op2 = profit(idx+2,0,prices,memo) + prices[idx];
        }
        int maxProfit = Math.max(op1,op2);
        return memo[idx][buy] = maxProfit;
    }
}
