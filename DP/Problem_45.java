import java.util.Arrays;

// Longest String chain
public class Problem_45 {
    public static int longestStrChain(String[] arr) {
        Arrays.sort(arr,(a,b) -> a.length()-b.length());
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                if(compar(arr[i],arr[j]) && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                }
                maxi = Math.max(maxi,dp[i]);
            }
        }
        
        return maxi;
    }

    public static boolean compar(String curr,String prev){
        int cuPtr = 0, prePtr = 0;
        if(curr.length() != prev.length() +1)
            return false;
        while(cuPtr < curr.length()){
                if(prePtr < prev.length() && curr.charAt(cuPtr) == prev.charAt(prePtr)){
                    cuPtr++;
                    prePtr++;
                }
                else{
                    cuPtr++;
                }
        }
        return prePtr == prev.length() && cuPtr == curr.length();
    }
}
