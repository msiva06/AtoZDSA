// Wildcard matching
public class Problem_34 {
    public static boolean wildcardMatching(String pattern, String text) {
		int p = pattern.length();
		int t = text.length();
		Boolean[][] memo = new Boolean[p+1][t+1];
		memo[0][0] = true;
		for(int i = 1; i <= t; i++){
			memo[0][i] = false;
		}
		for(int i = 1; i <= p; i++){
			memo[i][0] = isStar(i, pattern);
		}
		for(int i =1 ; i <=  p; i++){
			for(int j = 1; j <= t; j++){
				
				if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?')
					memo[i][j] = memo[i-1][j-1];
				else{
					if(pattern.charAt(i-1) == '*'){
						memo[i][j] = memo[i][j-1] || memo[i-1][j];
					}
					else
						memo[i][j] = false;
				}
			}
		}
		return memo[p][t];
		// for(int i = 0; i < memo.length; i++)
		// 	Arrays.fill(memo[i],null);
		// return match(p-1,t-1,pattern,text,memo);
	}

	public static boolean match(int p,int t,String pattern,String text,Boolean[][] memo){
		if(p < 0 && t < 0)
			return true;
		if(p < 0 && t >= 0)
			return false;
		if(t < 0 && p >= 0)
			return isStar(p,pattern);
		if(memo[p][t] != null)
			return memo[p][t];
		if(pattern.charAt(p) == text.charAt(t) || pattern.charAt(p) == '?')
			memo[p][t] =  match(p-1,t-1,pattern,text,memo);
		else{
			if(pattern.charAt(p) == '*')
			{
				memo[p][t] = match(p-1,t,pattern,text,memo) || match(p,t-1,pattern,text,memo);
			}
			else{
				memo[p][t] = false;
			}
		}
		return memo[p][t];
	}

	public static boolean isStar(int idx,String pattern){
		for(int i = 1; i <= idx; i++)
		{
			if(pattern.charAt(i-1) != '*')
				return false;
		}
		return true;
	}
}
