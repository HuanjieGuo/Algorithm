package offerAlgorithm.A_Offer_07_BuildTree;

import java.util.HashMap;
import java.util.Map;

/**
 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

  

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7
  

 限制：

 0 <= 节点个数 <= 5000

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Offer_07_BuildTree {
    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做

    private Map<Integer, Integer> reverses;
    int[] preorder;//保留的先序遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        this.preorder = preorder;
        reverses = new HashMap<>();
        // 中序列放进字典
        for(int i=0;i<inLen;i++){
            reverses.put(inorder[i],i);
        }

        return buildTreePI(0,preLen-1,0,inLen-1);
    }
    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
     */
    private TreeNode buildTreePI(int preL, int preR,
                               int inL, int inR) {
        if(preL>preR||inL>inR){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preL]);
        // 拿前序在中序中的坐标
        int pivot = reverses.get(preorder[preL]);
        treeNode.left = buildTreePI(preL+1,preL+(pivot-inL),inL,pivot-1);
        treeNode.right = buildTreePI(preL+(pivot-inL)+1,preR,pivot+1,inR);
        return treeNode;
    }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
}
