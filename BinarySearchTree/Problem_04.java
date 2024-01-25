package BinarySearchTree;

import java.util.ArrayList;

// Convert sorted array to BST
public class Problem_04 {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return constructLeft(arr,0,n-1);
        
    }

    public static TreeNode<Integer> constructLeft(ArrayList<Integer> arr,int low,int high){
        if(low > high)
            return null;
        int mid = low + (high - low)/2;
        TreeNode<Integer> root = new TreeNode(arr.get(mid));
        root.left = constructLeft(arr,low,mid-1);
        root.right = constructLeft(arr,mid+1,high);
        return root;
        
    }
}
