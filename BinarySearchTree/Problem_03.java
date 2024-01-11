package BinarySearchTree;

// LCA of two nodes in BST
public class Problem_03 {
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        int val = root.data;
        if(val > p.data && val > q.data){
            return LCAinaBST(root.left, p, q);
        }
        if(val < p.data && val < q.data)
            return LCAinaBST(root.right, p, q);
        return root;
    }
}
