// Minimal cost
public class Problem_04 {
    public static int minimizeCost(int n, int k, int []height){
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        memo[0] = 0;
        
        for(int i = 1; i < n; i++){
            int minCost = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    int cost = memo[i-j] + Math.abs(height[i] - height[i-j]);
                    minCost = Math.min(cost,minCost);
                }
            }
            memo[i] = minCost;
        }
        return memo[n-1];
        //return minCost(n,k,height,height.length-1,memo);
     }
 
     public static int minCost(int n,int k, int[] height,int idx,int[] memo){
         if(idx == 0){
             return 0;
         }
         if(memo[idx] != -1)
             return memo[idx];
         int minCost = Integer.MAX_VALUE;
         for(int i = 1; i <= k; i++){
             if(idx - i >= 0){
                 int cost = minCost(n,k,height,idx - i,memo) + Math.abs(height[idx] - height[idx-i]);
                 minCost = Math.min(cost,minCost);
             }
         }
         memo[idx] = minCost;
         return memo[idx];
     }
}
