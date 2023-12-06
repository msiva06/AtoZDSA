public class Problem_51 {
    // Palindrome partitioning II
    public static int palindromePartitioning(String str) {
        int n = str.length();
        int[] dp = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            int mini = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                if(isPalindrome(i,j,str)){
                    int partition = 1 + dp[j+1];
                    mini = Math.min(mini,partition);
                }
            }
            dp[i] = mini;
        }
        return dp[0]-1;
        // int[] memo = new int[n];
        // Arrays.fill(memo,-1);
        // return partition(0,str,memo) - 1;
    }

    public static int partition(int idx,String str,int[] memo){
        int n = str.length();
        if(idx == n)
            return 0;
        if(memo[idx] != -1)
            return memo[idx];
        int mini = Integer.MAX_VALUE;
        for(int j = idx; j < n; j++){
            if(isPalindrome(idx,j,str)){
                int partition = 1 + partition(j+1,str,memo);
                mini = Math.min(mini,partition);
            }
        }
        return memo[idx] = mini;
    }

    public static boolean isPalindrome(int left,int right,String s){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
