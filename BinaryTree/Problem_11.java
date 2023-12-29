package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Width of binary tree
public class Problem_11 {
    public static int getMaxWidth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxWidth = 0;
        if(root == null)
            return 0;
        
        while(!q.isEmpty()){
            int width = q.size();
            maxWidth = Math.max(width,maxWidth);
            for(int i = 0; i < width; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return maxWidth;
    }
}
