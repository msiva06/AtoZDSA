import java.util.Arrays;

// Longest Bitonic sequence
public class Problem_46 {
     public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j])
                    dp1[i] = Math.max(dp1[i],1 + dp1[j]);
            }
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                if(arr[i] > arr[j])
                    dp2[i] = Math.max(dp2[i],1 + dp2[j]);
            }
        }
        int maxi = 0;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi,dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}
