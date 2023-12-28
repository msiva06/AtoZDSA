package Strings;

// Look and Say
public class Problem_04 {
    public static String lookAndSaySequence(int n) {
		String prev = "1";
		String curr = prev;
		for(int i = 2; i <=n; i++){
			curr = "";
			int count = 1;
			for(int j = 1; j < prev.length(); j++){
				if(prev.charAt(j) != prev.charAt(j-1))
				{
					curr += count;
					curr += prev.charAt(j-1);
					count = 1;
				}
				else
					count++;	
			}
			curr += count;
			curr += prev.charAt(prev.length()-1);
			prev = curr;
		}
		return curr;
		
	}
}
