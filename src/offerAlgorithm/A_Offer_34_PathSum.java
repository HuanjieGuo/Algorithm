package offerAlgorithm;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

  

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
  

 提示：

 节点总数 <= 10000

 */
public class A_Offer_34_PathSum {
    List<List<Integer>> res;
    LinkedList<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        if(root==null) return new ArrayList<>();
        recur(root,sum);
        return res;
    }

    void recur(TreeNode root,int tar){
        tar = tar - root.val;
        list.add(root.val);
        // 叶子节点判断
        if(tar==0&&root.left==null&&root.right==null)  res.add((List<Integer>) list.clone());
        if(root.left!=null) recur(root.left,tar);
        if(root.right!=null) recur(root.right,tar);
        list.removeLast();
    }
}
