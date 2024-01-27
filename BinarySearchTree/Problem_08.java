package BinarySearchTree;

// Ceil in BST
public class Problem_08 {
    public  static int findCeil(TreeNode<Integer> node, int x) {

        TreeNode<Integer> root = node;
        TreeNode<Integer> succ = null;
        while(root != null){
            if(root.data < x){
                root = root.right;
            }
            else{
                succ = root;
                root =root.left;
            }
        }
        return succ == null ? -1 : succ.data;

    }
}
