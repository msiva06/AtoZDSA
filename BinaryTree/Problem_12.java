package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Level order traversalß
public class Problem_12 {
        
    public static List<Integer> levelOrder(TreeNode<Integer> root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size;i++){
                TreeNode<Integer> node = q.poll();
                res.add(node.data);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        return res;
    }
}
