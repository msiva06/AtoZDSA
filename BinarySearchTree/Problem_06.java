package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

// Predecessor and successor in BST
public class Problem_06 {
     public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        TreeNode succ = null;
        TreeNode pre = null;
        TreeNode node = root;
        while(node != null){
            if(node.data < key){
                
                pre = node;
                node = node.right;      
            }
            else{
                node = node.left;
            }
        }
        node = root;
        while(node != null){
            if(node.data <= key){
                node = node.right;      
            }
            else{
                succ = node;
                node = node.left;
            }
        }
        List<Integer> res = new ArrayList<>();
        int preVal = pre == null ? -1 : pre.data;
        int succVal = succ == null ? -1 : succ.data;
        res.add(preVal);
        res.add(succVal);
        return res;
    }
}
