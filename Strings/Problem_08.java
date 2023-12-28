package Strings;
// Longest Palindrome substring
public class Problem_08 {
    public static String longestPalinSubstring(String str) {
		int maxCount = 0;
		String res = "";
		for(int i = 0; i < str.length();i++){
			int left = i, right = i+1;
			while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
				if(right-left+1 > maxCount){
					res = str.substring(left,right+1);
					maxCount = right-left+1;
				}
				left--;
				right++;
				
			}
			left = i;
			right = i;
			while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
				if(right-left+1 > maxCount){
					res = str.substring(left,right+1);
					maxCount = right-left+1;
				}
				left--;
				right++;
				
			}
			
		}
		return res;
	}
}
