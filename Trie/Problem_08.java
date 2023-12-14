package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

// Maximum XOR With an Element From Array
public class Problem_08 {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        TrieNode root = new TrieNode();
        Collections.sort(arr);
        int n = queries.size();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        int[][] qArr = new int[n][3];
        for(int i = 0; i < queries.size();i++){
            int xi = queries.get(i).get(0);
            int ai = queries.get(i).get(1);
            int idx = i;
            qArr[i][0] = xi;
            qArr[i][1] = ai;
            qArr[i][2] = idx;
         }

        Arrays.sort(qArr,(a,b) -> a[1] - b[1]);

        for(int i = 0; i < qArr.length; i++){
            int xi = qArr[i][0];
            int ai = qArr[i][1];
            int idx = qArr[i][2];
            int max = -1;
            for(Integer a : arr){
                TrieNode node = root;
                if(a > ai)
                    continue;
                if(a <= ai){
                    node.insert(a, node);
                    
                }
                node = root;
                max = Math.max(max,node.getMax(xi,node));
                
            }
            res.set(idx,max);
        }
        return res;
    }
}
