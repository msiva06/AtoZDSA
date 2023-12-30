package BinaryTree;

// Lowest common ancestor
public class Problem_17 {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        TreeNode<Integer> node = lca(root,x,y);
        return node.data;
    }

    public static TreeNode<Integer> lca(TreeNode<Integer> root,int x, int y){
        if(root == null || root.data == x || root.data == y)
            return root;
        TreeNode<Integer> lt = lca(root.left,x,y);
        TreeNode<Integer> rt = lca(root.right,x,y);
        if(lt == null)
            return rt;
        else if(rt == null)
            return lt;
        else{
            return root;
        }
    }
}
