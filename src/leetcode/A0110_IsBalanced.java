package leetcode;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：

 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

  

 示例 1：


 输入：root = [3,9,20,null,null,15,7]
 输出：true
 示例 2：


 输入：root = [1,2,2,3,3,null,null,4,4]
 输出：false
 示例 3：

 输入：root = []
 输出：true
  

 提示：

 树中的节点数在范围 [0, 5000] 内
 -104 <= Node.val <= 104

 */
public class A0110_IsBalanced {
    // 左右节点绝对值不超过1
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return isBalance;
    }

    /**
     返回值为深度
     */
    int recur(TreeNode node){

        if(!isBalance) return 0;
        if(node==null) return 0;
        int left = recur(node.left);
        int right = recur(node.right);
        if(Math.abs(left-right)>1) isBalance = false;
        return Math.max(left,right)+1;

    }

}
