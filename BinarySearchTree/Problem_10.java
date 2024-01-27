package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

// Pair sum in BST
public class Problem_10 {
    public static boolean pairSumBst(TreeNode root, int k) {
       List<Integer> inorder = new ArrayList<Integer>();
       inorderTra(root,inorder);
       int left = 0, right = inorder.size()-1;
       while(left < right){
           int sum = inorder.get(left) + inorder.get(right);
           if(sum == k)
             return true;
           else if(sum < k){
               left++;
           }
           else{
               right--;
           }
       }
       return false;
    }

    public static void inorderTra(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        inorderTra(root.left,list);
        list.add(root.data);
        inorderTra(root.right,list);
    }
}
