package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    TreeNode root;
    int num;
    public Pair(TreeNode root,int num){
        this.root = root;
        this.num = num;
    }
}

// All tree traversal in single pass
public class Problem_10 {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));
        if(root == null){
            return res;
        }
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            TreeNode node = p.root;
            int n = p.num;
            if(n == 1){
                preorder.add(node.data);
                n++;
                stack.push(new Pair(node,n));
                if(node.left != null){
                    stack.push(new Pair(node.left,1));
                }
            }
            else if(n == 2){
                inorder.add(node.data);
                n++;
                stack.push(new Pair(node,n));
                if(node.right != null)
                    stack.push(new Pair(node.right,1));
            }
            else if(n == 3){
                postorder.add(node.data);
            }
        }
        res.add(new ArrayList<>(inorder));
        res.add(new ArrayList<>(preorder));
        res.add(new ArrayList<>(postorder));
        return res;
    }
}
