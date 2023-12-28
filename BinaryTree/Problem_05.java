package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// Morris preorder traversal
public class Problem_05 {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	
		List<Integer> res = new ArrayList<>();
		while(root != null){
			if(root.left == null){
				res.add(root.data);
				root = root.right;
			}
			else{
				TreeNode node = root.left;
				while(node.right != null && node.right != root){
					node = node.right;
				}
				if(node.right == null){
					node.right = root;
					res.add(root.data);
					root = root.left;
				}
				else{
					node.right = null;
					root = root.right;
				}
			}
		}
		return res;
    }
}
