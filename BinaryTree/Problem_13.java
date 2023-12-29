package BinaryTree;

// Height of binary tree
public class Problem_13 {
    public static int heightOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int height = 1;
        int leftHeight = 0, rightHeight = 0;
        if(root.left != null){
            leftHeight = heightOfBinaryTree(root.left);
        }
        if(root.right != null){
            rightHeight = heightOfBinaryTree(root.right);
        }

        return height + Math.max(leftHeight,rightHeight);
    }
}
