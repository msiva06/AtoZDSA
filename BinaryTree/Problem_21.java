package BinaryTree;

import java.util.HashMap;
import java.util.Map;

// Construct binary tree from preorder and inorder
public class Problem_21 {
    int preOrderIdx;
    Map<Integer,Integer> inOrderIdxMap = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIdx = 0;
        for(int i = 0;i < inorder.length;i++)
            inOrderIdxMap.put(inorder[i],i);
        TreeNode node = constructTree(0,inorder.length-1,inorder,preorder);
        return node;
    }

    public TreeNode constructTree(int start,int end,int[] inorder,int[] preorder){
        if(start > end)
            return null;
        TreeNode root = new TreeNode(preorder[preOrderIdx]);
        int inIdx = inOrderIdxMap.get(preorder[preOrderIdx]);
        preOrderIdx++;
        root.left = constructTree(start,inIdx-1,inorder,preorder);
        root.right = constructTree(inIdx+1,end,inorder,preorder);
        return root;
    }
}
