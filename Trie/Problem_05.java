package Trie;

class TrieNode{
  TrieNode[] children;
  boolean eof;
  public TrieNode(){
    children = new TrieNode[26];
    eof = false;
  }
}

// Complete String
public class Problem_05 {
    public static String completeString(int n, String[] a) {
        TrieNode root = new TrieNode();
        for(String s : a){
          insert(root,s);
        }
    
        String longest = "";
        for(String s : a){
          if(check(root,s))
          {
            if(s.length() > longest.length())
              longest = s;
            else if(s.length() == longest.length() && s.compareTo(longest) < 0)
              longest = s;
          }
        }
        return longest == "" ? "None" : longest;
      }
    
      public static void insert(TrieNode root, String s){
        for(int i = 0; i< s.length(); i++){
          char c = s.charAt(i);
          if(root.children[c - 'a'] == null){
            root.children[c - 'a'] = new TrieNode();
          }
          root = root.children[c - 'a'];
        }
        root.eof = true;
      }
    
      public static boolean check(TrieNode root,String str){
          boolean flag = true;
          for(int j = 0; j < str.length();j++){
            char c = str.charAt(j);
            int idx = c - 'a';
            if(root.children[idx] != null){
              root = root.children[idx];
              flag = flag & root.eof;
            }
            else 
              return false;
          }
            return flag;
          } 
}
