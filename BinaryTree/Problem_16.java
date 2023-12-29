package BinaryTree;

// Is height balanced binary tree
public class Problem_16 {
    
    public static boolean isBalancedBT(TreeNode<Integer> root) {
        return checkBalanced(root) != -1;
    }

    public static int checkBalanced(TreeNode<Integer> root){
        if(root == null)
            return 0;
        int lt = checkBalanced(root.left);
        if(lt == -1)
            return -1;
        int rt = checkBalanced(root.right);
        if(rt == -1)
            return -1;
        if(Math.abs(lt-rt) > 1)
            return -1;
        return 1 + Math.max(lt,rt);
    }
}
