package Trie;

class TrieNode{
    TrieNode[] children;
    boolean eof;
    public TrieNode(){
        children = new TrieNode[26];
        eof = false;
    }
}

// Implement Trie
public class Problem_01 {
    static TrieNode root;

    //Initialize your data structure here

    Problem_01() {
        root = new TrieNode();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.eof = true;
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null)
                return false;
            node = node.children[c - 'a'];
        }
        return node.eof;
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i <prefix.length(); i++){
            char c= prefix.charAt(i);
            if(node.children[c - 'a'] == null)
                return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}
