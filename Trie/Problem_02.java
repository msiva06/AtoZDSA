package Trie;

class TrieNode{
    TrieNode[] children ;
    boolean eof;
    int eow;
    int cp;
    public TrieNode(){
        children = new TrieNode[26];
        eof = false;
        eow = 0;
        cp = 0;
    }
}

// Implement Trie II 
public class Problem_02 {
    TrieNode root;
    public Problem_02() {
        root = new TrieNode();
        // Write your code here.
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.cp += 1;
        }
        node.eof = true;
        node.eow += 1;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                break;
            node = node.children[c - 'a'];
        }
        return (node.eof) ? node.eow : 0;
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                return 0;
            node = node.children[c - 'a'];
        }
        return node.cp;
    }

    public void erase(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                return;
            node = node.children[c - 'a'];
            node.cp -= 1;
        }
        node.eow -= 1;
    }
}
