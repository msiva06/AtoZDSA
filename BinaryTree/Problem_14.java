package BinaryTree;

// Diameter of binary tree
public class Problem_14 {
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        int[] diameter = new int[1];
        heightOfBinaryTree(root,diameter);
        return diameter[0];
 
     }
 
     public static int heightOfBinaryTree(TreeNode<Integer> root,int[] diameter){
         if(root == null)
             return 0;
         int lh = heightOfBinaryTree(root.left, diameter);
         int rh = heightOfBinaryTree(root.right, diameter);
         diameter[0] = Math.max(diameter[0],lh+rh);
         return 1 + Math.max(lh,rh);
     }
}
