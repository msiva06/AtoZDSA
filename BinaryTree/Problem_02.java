package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Preorder traversal
public class Problem_02 {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			res.add(node.data);

			if(node.right != null){
				stack.push(node.right);
			}
	
			if(node.left != null){
				stack.push(node.left);
			}
				
		}
		return res;
    }
}
