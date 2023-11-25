// Target sum
public class Problem_21 {
    public static int targetSum(int n, int target, int[] arr) {
    	int totsum = 0;
        for(int a : arr)
            totsum += a;
        int tar = (totsum - target)/2;
        if(totsum - target < 0)
            return 0;
        if((totsum - target) % 2 != 0)
            return 0;
        int[][] memo = new int[n][tar+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= tar; j++){
                if(i == 0 && j == 0 && arr[0] == 0){
                    memo[0][j] = 2;
                    continue;
                }     
                else if(i == 0 && (j == 0 || arr[0] == j)){
                    memo[0][j] = 1;
                    continue;
                }
                else if(i > 0){
                    int notpick = memo[i-1][j];
                    int pick = 0;
                    if(arr[i] <= j){
                        pick = memo[i-1][j-arr[i]];
                    }
                    memo[i][j] = pick + notpick;
                }

            }
        }
        return memo[n-1][tar];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(memo[i],-1);
        // }
        // return findWays(n-1,tar,arr,memo);
    }

    public static int findWays(int idx,int target,int[] arr,int[][] memo){
        if(idx == 0){
            if(target == 0 && arr[idx] == 0)
                return 2;
            if(target == 0 || arr[idx] == target)
                return 1;
            return 0;
        }

        if(memo[idx][target] != -1)
            return memo[idx][target];
        int notpick = findWays(idx-1, target, arr,memo);
        int pick = 0;
        if(arr[idx] <= target)
            pick = findWays(idx-1, target-arr[idx], arr,memo);
        memo[idx][target] = pick + notpick;
        return memo[idx][target];
    }
}
