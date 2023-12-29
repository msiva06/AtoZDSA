package BinaryTree;

// Check Identical trees
public class Problem_15 {
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null)
            return false;
        if(root1.data != root2.data)
            return false;
        boolean lt = identicalTrees(root1.left, root2.left);
        if(lt == false)
            return false;
        boolean rt = identicalTrees(root1.right,root2.right);
        if(rt == false)
            return false;
        return true;
    }
}
