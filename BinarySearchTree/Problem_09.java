package BinarySearchTree;

// Kth smallest node in BST
public class Problem_09 {
    static int count = 0;
    public static int kthSmallest(TreeNode root, int k) {
       int[] val = new int[1];
       kthSmall(root,k,val);
       return val[0];
        
    }

    public static void kthSmall(TreeNode root,int k,int[] val){
        if(root == null)
            return;
        kthSmall(root.left,k,val);
        count++;
        if(count == k){
            val[0] = root.data;
            return;
        }
        kthSmall(root.right,k,val);
        
    }
}
