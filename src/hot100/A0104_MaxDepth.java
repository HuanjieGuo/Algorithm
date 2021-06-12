package hot100;

import dataStructure.TreeNode;

public class A0104_MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
