package offerAlgorithm.A_Offer_55;

import dataStructure.TreeNode;

/**
 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

 例如：

 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。

  

 提示：

 节点总数 <= 10000

 */
public class Offer_55_1_MaxDepth {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    int dfs(TreeNode root){
        if (root==null)return 0;
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}
