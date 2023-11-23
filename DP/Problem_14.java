// Subset sum equal to K
public class Problem_14 {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        //int[][] memo = new int[n][k+1];
        boolean[][] memo = new boolean[n][k+1];
        for(int i = 0; i < n; i++){
            memo[i][0] = true;
        }
        if(arr[0] <= k)
            memo[0][arr[0]] = true;
        for(int i = 1; i < n;i++){
            for(int tar = 1; tar <= k; tar++){
                boolean notpick = memo[i-1][tar];
                boolean pick = false;
                if(arr[i] <= tar)
                    pick = memo[i-1][tar-arr[i]];
                memo[i][tar] = pick || notpick;
            }
        }
        return memo[n-1][k];
        // for(int i = 0; i < memo.length; i++)
        //     Arrays.fill(memo[i],-1);

        // return checkSubSet(n-1,k,arr,memo);
    }

    public static boolean checkSubSet(int i,int k,int[] arr,int[][] memo){
        if(k == 0)
            return true;
        if(i == 0){
            return arr[i] == k;
        }
       
        if(memo[i][k] != -1)
            return memo[i][k] == 1 ? true : false;
        boolean pick = false;
        boolean notpick = checkSubSet(i-1, k, arr,memo);
        if(arr[i] <= k){
            pick = checkSubSet(i-1, k-arr[i], arr,memo);
        }
        
       memo[i][k] = (pick || notpick) ? 1 : 0;
        return pick || notpick;
    }
}
