package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// Vertical order traversal
public class Problem_09 {
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode<Integer> curr = p.node;
            int l = p.line;
            if(!map.containsKey(l)){
                map.put(l, new ArrayList<>());
            }
            map.get(l).add(curr.data);
            if(curr.left != null){
                q.offer(new Pair(curr.left,l-1));
            }
            if(curr.right != null){
                q.offer(new Pair(curr.right,l+1));
            }
        }
        for(Map.Entry<Integer,List<Integer>> m : map.entrySet()){
            List<Integer> iList = m.getValue();
            res.addAll(iList);
        }
        return res;
    }
}
