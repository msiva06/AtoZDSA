import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Printing Longest increasing subsequence
public class Problem_41 {
   public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i = 0; i < n; i++)
            hash[i] = i;

        for(int i = 0; i < n; i++){
            Arrays.fill(dp,1);
        }
        int maxi = -1;
        int largeIdx = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < 1 + dp[j]){
                    dp[i] =  1 + dp[j];
                    hash[i] = j;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dp[i] > maxi){
                maxi = dp[i];
                largeIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(arr[largeIdx]);
        while(hash[largeIdx] != largeIdx){
            largeIdx = hash[largeIdx];
            res.add(arr[largeIdx]);
        }
        Collections.reverse(res);
        //res.stream().forEach(System.out::println);
        return res;
    } 
}
