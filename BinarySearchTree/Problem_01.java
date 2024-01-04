package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

// Connect Nodes at Same Level
public class Problem_01 {
    public static void connectNodes(BinaryTreeNode<Integer> root) {
    	Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()){
			int size = q.size();
			BinaryTreeNode<Integer> prev = null;
			for(int i = 0; i <size; i++){
				BinaryTreeNode<Integer> node = q.poll();
				if(prev != null){
					prev.next = node;
				}
				if(node.left != null)
					q.offer(node.left);
				if(node.right != null)
					q.offer(node.right);
				prev = node;
			}
		}
	}
}
