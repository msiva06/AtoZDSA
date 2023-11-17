// ClimbStairs
public class Problem_02 {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0] = 1;
        memo[1] = 1;
        int curr = 1;
        int prev = memo[1];
        int prev2 = memo[0];
        for(int i =2; i <= n; i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
        //return count(memo,n);
    }

    public int count(int[] memo,int n){
        if(n <= 1)
            return 1;
        if(memo[n] != -1)
            return memo[n];
        int oneStep = count(memo,n-1);
        int twoStep = count(memo,n-2);
        memo[n] = oneStep + twoStep;
        return memo[n];
    }
}
