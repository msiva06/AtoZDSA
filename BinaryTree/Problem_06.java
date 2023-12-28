package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// Left view of binary tree
public class Problem_06 {

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        leftView(root,res,0,ds);
        return res;
    }

    public static void leftView(TreeNode<Integer> root,ArrayList<Integer> res,int level,
    List<Integer> ds){
        if(root == null)
            return;
        if(level == ds.size()){
            res.add(root.data);
        }
        leftView(root.left, res, level+1, res);
        leftView(root.right, res, level+1, res);
    }
}
