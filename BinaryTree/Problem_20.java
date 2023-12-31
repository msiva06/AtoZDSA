package BinaryTree;

import java.util.HashMap;
import java.util.Map;

// Construct binary tree from inorder and postorder
public class Problem_20 {
    int postOrderIndex;
    Map<Integer,Integer> inOrderIdxMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;
        for(int i = 0; i < inorder.length; i++){
            inOrderIdxMap.put(inorder[i],i);
        }
        TreeNode node = constructTree(0,inorder.length-1,inorder,postorder);
        return node;
    }

    public TreeNode constructTree(int start,int end,int[] inorder,int[] postorder){
        if(start  > end)
            return null;
    
        TreeNode root = new TreeNode(postorder[postOrderIndex]);
        int inIdx = inOrderIdxMap.get(postorder[postOrderIndex]);
        postOrderIndex--;
        root.right = constructTree(inIdx+1,end,inorder,postorder);
        root.left = constructTree(start,inIdx-1,inorder,postorder);
        return root;
    }
}
