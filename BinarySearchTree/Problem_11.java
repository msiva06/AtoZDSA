package BinarySearchTree;

import java.util.Stack;

// BST Iterator
public class Problem_11 {
    static class BSTIterator{
        Stack<TreeNode<Integer>> st;

        BSTIterator(TreeNode<Integer> root){
            st = new Stack<TreeNode<Integer>>();
            leftMost(root);
        }

        int next(){
            TreeNode<Integer> top = st.pop();
            if(top.right != null){
                leftMost(top.right);
            }
            return top.data;
        }

        boolean hasNext(){
            if(st.size() > 0)
                return true;
            return false;
        }

        void leftMost(TreeNode<Integer> root){
            while(root != null){
                st.push(root);
                root = root.left;
            }
        }
    }
}
