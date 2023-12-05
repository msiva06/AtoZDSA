import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Divisible set
public class Problem_44 {
    public static List< Integer > divisibleSet(int []arr) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i = 0; i < n;i++)
            Arrays.fill(dp,1);
        for(int i = 0; i < n; i++)
            hash[i] = i;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0 && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }
        int maxi = -1;
        int lastIdx = -1;
        for(int i = 0; i < n; i++){
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIdx = i;
            }
        }
        res.add(arr[lastIdx]);
        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            res.add(arr[lastIdx]);
        }
        Collections.reverse(res);
        return res;
    }
}
