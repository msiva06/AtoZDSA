package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Inorder Traversal
public class Problem_01 {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //inOrder(root,res);
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.right;
        }
        return res;
    }

    public static void inOrder(TreeNode root,List<Integer> res){
        if(root == null)
            return;
        inOrder(root.left,res);
        res.add(root.data);
        inOrder(root.right,res);
    }
}
