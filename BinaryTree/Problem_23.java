package BinaryTree;

// Symmetrical Binary tree
public class Problem_23 {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        TreeNode node = root;
        return symmetric(node.left,root.right);
    }

    public static boolean symmetric(TreeNode node, TreeNode root){
        if(root == null && node == null)
            return true;
        if(root == null || node == null)
            return false;
        if(root.data != node.data)
            return false;
        return symmetric(node.left,root.right) && symmetric(node.right,root.left);
    }
}
