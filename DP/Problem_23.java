// Unbounded Knapsack
public class Problem_23 {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] memo = new int[n][w+1];
        for(int i = 0; i <= w; i++){
            if(i % weight[0] == 0)
                 memo[0][i] = (int) (i / weight[0]) * profit[0];
        }
        for(int i = 1; i < n;i++){
            for(int j = 0; j <= w;j++){
                int notpick = memo[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(weight[i] <= j)
                 pick = profit[i] + memo[i][j-weight[i]];
                memo[i][j] = Math.max(pick,notpick);
            }
        }
        return memo[n-1][w];
     //    for(int i = 0; i <n ; i++)
     //     Arrays.fill(memo[i],-1);
     //    return knap(n-1,w,profit,weight,memo);
     }
 
     public static int knap(int idx,int maxWeight,int[] profit,int[] weight,int[][] memo){
         if(idx == 0){
             if(maxWeight % weight[idx] == 0){
                 return (maxWeight/weight[idx]) * profit[idx];
             }
             return 0;
         }
         if(memo[idx][maxWeight] != -1)
             return memo[idx][maxWeight];
         int notpick = 0+ knap(idx-1,maxWeight,profit,weight,memo);
         int pick = Integer.MIN_VALUE;
         if(weight[idx] <= maxWeight){
             pick = profit[idx] + knap(idx,maxWeight-weight[idx],profit,weight,memo);
         }
         memo[idx][maxWeight] =  Math.max(pick,notpick);
         return memo[idx][maxWeight];
     }
}
