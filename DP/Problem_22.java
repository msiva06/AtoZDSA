// Ways to make coin change
public class Problem_22 {
    public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
		long[][] memo = new long[n][value+1];
		// for(int i = 0; i<n;i++)
		// 	Arrays.fill(memo[i],-1);
		// return count(n-1,denominations,value,memo);	
		for(int i = 0; i <= value; i++){
			if(i % denominations[0] == 0)
				memo[0][i] = 1;
		}
		for(int i = 1; i < n; i++){
			for(int j = 0; j <= value; j++){
				long notpick = memo[i-1][j];
				long pick = 0;
				if(denominations[i] <= j)
					pick = memo[i][j-denominations[i]];
				memo[i][j] = pick + notpick;	
			}
		}	
		return memo[n-1][value];

	}

	public static long count(int idx,int[] den,int value,long[][] memo){
		if(idx == 0){
			return (value % den[idx] == 0)?1:0;
		}
		if(memo[idx][value] != -1)
			return memo[idx][value];
		long notpick = 0 + count(idx-1,den,value,memo);
		long pick = 0;
		if(den[idx] <= value)
			pick = count(idx,den,value-den[idx],memo);
		memo[idx][value] =  pick + notpick;
		return memo[idx][value];
	}
}
