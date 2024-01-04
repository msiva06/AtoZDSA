package BinarySearchTree;

// Search in BST
public class Problem_02 {
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MIN_VALUE;
       return search(low,high,root,x);
    }

    public static boolean search(int low,int high,BinaryTreeNode root, int x){
        if(root == null)
            return false;
        if(low > high)
            return false;
        if(root.data == x)
            return true;
        boolean left = false,right = false;
        if(x < root.data)
            left = search(x,root.data,root.left,x);
        else if(x > root.data)
            right = search(root.data,x,root.right,x);
        
        return left || right;
    }
}
