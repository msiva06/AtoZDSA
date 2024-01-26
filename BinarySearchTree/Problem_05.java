package BinarySearchTree;

// Partial BST
public class Problem_05 {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean checkBST(BinaryTreeNode<Integer> root,int low,int high){
        if(root == null)
            return true;
        if(low > high)
            return false;
        if(root.data < low || root.data > high)
            return false;
        return checkBST(root.left,low,root.data) && checkBST(root.right,root.data,high);
    }
}
