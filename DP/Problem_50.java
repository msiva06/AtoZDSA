// Partition array for maximum sum
public class Problem_50 {
    public static int maximumSubarray(int arr[], int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            int len = 0;
            int maxElem = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            for(int j = i; j < Math.min(i+k,n); j++){
                len++;
                maxElem = Math.max(maxElem,arr[j]);
                int sum = (len * maxElem) + dp[j+1];
                maxi = Math.max(maxi,sum);
            }
            dp[i] = maxi;
        }
        return dp[0];
        // int[] memo = new int[n];
        // Arrays.fill(memo,-1);
        // return maxSub(0,arr,k,memo);
    }

    public static int maxSub(int i,int[] arr,int k,int[] memo){
        if(i == arr.length)
            return 0;
        if(memo[i] != -1)
            return memo[i];
        int maxi = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(i+k,arr.length); j++){
            int maxSubSum = getMaxSubSum(i,j,arr);
            int sum = maxSubSum + maxSub(j+1,arr,k,memo);
            maxi = Math.max(maxi,sum);
        }
        return memo[i] = maxi;
    }

    public static int getMaxSubSum(int i,int j,int[] arr){
        int noElem = j - i + 1;
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            max = Math.max(max,arr[k]);
        }
        return max * noElem;
    }
}
