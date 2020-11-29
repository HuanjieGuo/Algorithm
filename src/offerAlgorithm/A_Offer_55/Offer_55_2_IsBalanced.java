package offerAlgorithm.A_Offer_55;

import dataStructure.TreeNode;

/**
 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

  

 示例 1:

 给定二叉树 [3,9,20,null,null,15,7]

 3
 / \
 9  20
 /  \
 15   7
 返回 true 。

 示例 2:

 给定二叉树 [1,2,2,3,3,null,null,4,4]

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 返回 false 。

  

 限制：

 1 <= 树的结点个数 <= 10000

 */
public class Offer_55_2_IsBalanced {
    boolean isBalance;
    public boolean isBalanced(TreeNode root) {
        isBalance = true;
        dfsCheck(root);
        return isBalance;
    }



    int dfsCheck(TreeNode root){
        if(root==null) return 0;
        if(!isBalance) return 0;
        int left = dfsCheck(root.left);
        int right = dfsCheck(root.right);
        System.out.println("root "+root.val+"   "+left+" "+right);
        if(Math.abs(left-right)>1)
            isBalance = false;
        return Math.max(left,right)+1;
    }
}
