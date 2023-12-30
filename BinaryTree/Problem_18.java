package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// Boundary Traversal of binary tree
public class Problem_18 {
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> res = new ArrayList<>();
        res.add(root.data);
        leftBoundary(root,res);
        leafNodes(root,res);
        rightBoundary(root,res);
        return res;
    }

    public static boolean isLeafNode(TreeNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }

    public static void leftBoundary(TreeNode root,List<Integer> res){
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeafNode(curr))
                res.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else    
                curr = curr.right;
        }
    }

    public static void leafNodes(TreeNode root,List<Integer> res){
        TreeNode curr = root;
            if(isLeafNode(root)){
                res.add(root.data);
                return;
            }
                
            if(curr.left != null)
                leafNodes(curr.left, res);
            if(curr.right != null)
                leafNodes(curr.right, res);
    }

    public static void rightBoundary(TreeNode root,List<Integer> res){
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeafNode(curr)){
                temp.add(curr.data);
            }
            if(curr.right != null)
                curr =curr.right;
            else
                curr = curr.left;
        }
        for(int i = temp.size()-1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }
}
