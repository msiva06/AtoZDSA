package Trie;

// Count distinct substrings
public class Problem_06 {
    public static int countDistinctSubstrings(String s) 
	{
		TrieNode root = new TrieNode();
		int count = 0;
		for(int i = 0; i < s.length();i++){
			TrieNode node = root;
			for(int j = i; j < s.length();j++){
				char c = s.charAt(j);
				int idx = c - 'a';
				if(node.children[idx] == null){
					count++;
					node.children[idx] = new TrieNode();
				}
				node = node.children[idx];
			}
		}
		return count +1;
	}
}
