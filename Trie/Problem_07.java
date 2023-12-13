package Trie;

class TrieNode{
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[2];
    }

    public void insert(int num,TrieNode node){
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.children[bit] == null){
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    public int getMax(int num,TrieNode node){
        int maxNum = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.children[1-bit] != null){
                maxNum = maxNum | 1 << i;
                node = node.children[1-bit];
            }
            else{
                node = node.children[bit];
            }
        }
        return maxNum;
    }
}

// Maximum XOR of two numbers in array
public class Problem_07 {
    public static int maximumXor(int []A) {
        TrieNode root = new TrieNode();
        for(int a : A){
            TrieNode node = root;
            node.insert(a,node);
        }

        int maxi = 0;
    
        for(int i = 0; i < A.length;i++){
            TrieNode node = root;
            maxi = Math.max(maxi,node.getMax(A[i],node));
        }
        return maxi;
    }
}
