package BinaryTree;

// Maximum sum path of binary tree
public class Problem_22 {
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPath(root,maxi); 
        return maxi[0];   
    }

    public static int maxPath(BinaryTreeNode<Integer> root, int[] maxi){
        if(root == null)
            return 0;
        int lsum = maxPath(root.left,maxi);
        if(lsum < 0)
            lsum = 0;
        int rsum = maxPath(root.right,maxi);
        if(rsum < 0)
            rsum = 0;
        maxi[0] = Math.max(maxi[0],root.data + lsum + rsum);
        return root.data + Math.max(lsum,rsum);
    }
}
