import java.util.Arrays;

// Longest Palindromic subsequence
public class Problem_28 {
    public static int longestPalindromeSubsequence(String s) {
		StringBuilder srev = new StringBuilder(s);
		srev = srev.reverse();
		String rev = srev.toString();
		int n = s.length();
		int m = rev.length();
		int[][] memo = new int[n+1][m+1];
		for(int i = 0; i <= n; i++){
			Arrays.fill(memo[i],-1);
		}
		return longestPali(n-1,m-1,s,rev,memo);
	}

	public static int longestPali(int id1,int id2,String s1,String s2,int[][] memo){
		if(id1 < 0 || id2 < 0)
			return 0;
		if(memo[id1][id2] != -1)
			return memo[id1][id2];
		if(s1.charAt(id1) == s2.charAt(id2))
			memo[id1][id2] =  1 + longestPali(id1-1, id2-1, s1, s2,memo);
		else
			memo[id1][id2] = Math.max(longestPali(id1-1,id2,s1,s2,memo), longestPali(id1, id2-1, s1, s2,memo));
		return memo[id1][id2];
	}
}
