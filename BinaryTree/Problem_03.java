package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Post order traversal
public class Problem_03 {
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if(root == null)    
            return res;
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left != null){
                s1.push(root.left);
            }
            if(root.right != null){
                s1.push(root.right);
            }
        }
        while(!s2.isEmpty()){
            res.add(s2.pop().data);
        }
        return res;
    }
}
