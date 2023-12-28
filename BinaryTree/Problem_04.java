package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// Morris Inorder
public class Problem_04 {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while(root != null){
            if(root.left == null){
            res.add(root.data);
            root = root.right;
        }
        else{
            TreeNode node = root.left;
            while(node.right != null && node.right != root){
                node = node.right;
            }
            if(node.right == null)
            {
                node.right = root;
                root = root.left;
            }
            else{
                node.right = null;
                res.add(root.data);
                root = root.right;
            }

        }
        }
        
        
        return res;
    }
}
