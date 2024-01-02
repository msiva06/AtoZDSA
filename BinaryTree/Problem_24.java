package BinaryTree;

// Flatten binary tree to linkedlist
public class Problem_24 {
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        TreeNode<Integer> node = root;
		while(node != null){
			if(node.left != null){
				TreeNode curr = node.left;
				while(curr.right != null){
					curr = curr.right;
				}
				curr.right = node.right;
				node.right = node.left;
				node.left = null;
			}
			node = node.right;
		}
		return root;
    }
}
