package Trie;


class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEnd;

    TrieNode() {
        isEnd = false;

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
// Trie Delete operation
public class Problem_03 {
    public static TrieNode deleteWord(TrieNode root, String word) {
        TrieNode node = root;
        return deleteWordHelper(node,word,0);
    }

    public static TrieNode deleteWordHelper(TrieNode root,String word, int depth){
        TrieNode node = root;
        if(node == null)
            return null;
        if(depth == word.length()){
             if(node.isEnd){
                node.isEnd = false;
            }
            if(isEmpty(node))
            {
                node = null;
            }
           
            return node;
        }
        char c = word.charAt(depth);
        int idx = c - 'a';
        node.children[idx] = deleteWordHelper(node.children[idx], word, depth+1);
        if(isEmpty(node) && node.isEnd == false)
            node = null;
        return node;

        
        
        
    }

    public static boolean isEmpty(TrieNode root){
        TrieNode node = root;
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null)
                return false;
        }
        return true;
    }
}
