package Trie;

class TrieNode{
	TrieNode[] children;
	boolean eof;
	int prefixCount;
	char data;
	int childCount;
	public TrieNode(){
		data = 0;
		children = new TrieNode[26];
		eof = false;
		prefixCount = 0;
		childCount = 0;

	}
}

//Longest common prefix
public class Problem_04 {
    public static String longestCommonPrefix(String[] arr, int n) {
		TrieNode root = new TrieNode();
		for(String a : arr){
			insert(root,a);
		}
		return computeLongestPrefix(root,n);
	}

	public static void insert(TrieNode root,String word){
		for(int i = 0; i < word.length(); i++){
			char c= word.charAt(i);
			int idx = c - 'a';
			if(root.children[idx] == null){
				root.children[idx] = new TrieNode();
				root.childCount++;
				root.prefixCount =1; 
			}
            else{
                root.prefixCount ++;
            }	
            root.data = c;	
			
			root = root.children[idx];
		}
		root.eof = true;
	}

	public static String computeLongestPrefix(TrieNode root,int length){
		StringBuilder sb = new StringBuilder();
			while(root.prefixCount == length){
				char c = root.data;
                sb.append(c);
				if(root.childCount > 1)
					break;
				int idx = getIndex(root);
				root = root.children[idx];
			}
		return sb.toString();
	}

    public static int getIndex(TrieNode root){
		int idx = -1;
		for(int i = 0; i < 26; i++){
			if(root.children[i] != null){
				idx = i;
				break;
			}
		}
		return idx;
	}
}
