import java.util.Arrays;

// Number of Longest increasing subsequence
public class Problem_47 {
    public static int findNumberOfLIS(int []arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(arr[i] > arr[prev] && dp[i] < 1 + dp[prev]){
                    dp[i] = 1 + dp[prev];
                    cnt[i] = cnt[prev];
                }
                else if(arr[i] > arr[prev] && dp[i] == 1 + dp[prev]){
                    cnt[i] += cnt[prev];
                }     
            }
            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxi)
                count += cnt[i];
        }
       
        return count;
    }
}
