// Fibonacci Series(memoization and Tabulation)
public class Problem_01 {
    public static int fib(int n){
		int[] memo = new int[n+1];
		Arrays.fill(memo,-1);
		//int fib = fibonacci(n,memo);
		memo[0] = 0;
		memo[1] = 1;
		for(int i = 2; i <= n; i++){
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
    }
    public static int fibonacci(int n,int[] memo){
		if(n <= 1)
			return n;
		if(memo[n] != -1)
			return memo[n];
		memo[n] = fibonacci(n-1,memo) + fibonacci(n-2,memo);
		return memo[n];
	}
}
