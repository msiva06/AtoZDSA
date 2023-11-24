// 0/1 KnapSack 
public class Problem_19 {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Change in the given tree itself.
        * No need to return or print the output.
        * Taking input and printing output is handled automatically.
        */
        int[][] memo = new int[n][maxWeight + 1];
        // for(int i = 0; i < n;i++)
        //     Arrays.fill(memo[i],-1);
        // return knap(n-1,weight,value,maxWeight,memo);
        for(int i = weight[0]; i <= maxWeight; i++){
                memo[0][i] = value[0];
        }
       

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= maxWeight; j++){
                int notpick = memo[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(weight[i] <= j){
                    pick = value[i] + memo[i-1][j-weight[i]];
                }
                memo[i][j] = Math.max(pick,notpick);
            }
        }
        return memo[n-1][maxWeight];

}

public static int knap(int idx,int[] weight,int[] value,int maxWeight,int[][] memo){
    if(idx == 0){
        if(weight[idx] <= maxWeight)
            return value[idx];
        return 0;
    }
    if(memo[idx][maxWeight] != -1)
        return memo[idx][maxWeight];
    int notpick = 0 + knap(idx - 1,weight,value,maxWeight,memo);
    int pick = Integer.MIN_VALUE;
    if(weight[idx] <= maxWeight)
        pick = value[idx] + knap(idx - 1,weight,value,maxWeight-weight[idx],memo);
    
    memo[idx][maxWeight] =  Math.max(pick,notpick);
    return memo[idx][maxWeight];
} 
}
