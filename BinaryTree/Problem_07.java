package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
    TreeNode node;
    int line;
    public Pair(TreeNode node,int line){
        this.node = node;
        this.line = line;
    }
}
// Top view of binary tree
public class Problem_07 {
    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode curr = p.node;
            int l= p.line;
            if(!map.containsKey(l))
                map.put(l,curr.data);
            if(curr.left != null){
                q.offer(new Pair(curr.left,l-1));
            }
            if(curr.right != null){
                q.offer(new Pair(curr.right,l+1));
            }
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            res.add(m.getValue());
        }
        return res;
    }
}
