package BinarySearchTree;

// Floor in BST
public class Problem_07 {
    public static int floorInBST(TreeNode<Integer> root, int X) {
        TreeNode<Integer> node =root;
        TreeNode<Integer> pre = null;
        while(node != null){
            if(node.data <= X){
                pre = node;
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        return pre == null ? -1 : pre.data;
    }
}
