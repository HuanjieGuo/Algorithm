package hot100;

import dataStructure.TreeNode;

public class A0124_MaxPathSum {
    // 记录所有 l+m+r的最大值
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxSum = Integer.MIN_VALUE;
        searchSum(root);
        return maxSum;
    }
    int searchSum(TreeNode node){
        if(node==null) return 0;
        // 计算左子树能往上传的最大值
        int left  = searchSum(node.left);
        // 计算右子树能往上传的最大值
        int right = searchSum(node.right);
        // 左中上情况，判断是否加入左子树
        int lm = node.val+Math.max(0,left);
        // 右中上情况，判断是否加入右子树
        int rm = node.val+Math.max(0,right);
        // 左中右情况，判断是否加入左右子树
        int lmr = node.val+Math.max(left,0)+Math.max(right,0);
        // 记录左中右最大值
        maxSum = Math.max(lmr,maxSum);
        // 把左中和右中的最佳情况传递给父节点
        return Math.max(lm,rm);
    }
}
