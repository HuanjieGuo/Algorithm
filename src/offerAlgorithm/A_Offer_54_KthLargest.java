package offerAlgorithm;

import dataStructure.TreeNode;

public class A_Offer_54_KthLargest {
    int count;
    int res;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root.right!=null&&count>0) dfs(root.right);
        // 本处-- 放置位置，让其由右根部往上计数，确保最深的点能被访问！
        count--;
        if(count==0){
            res = root.val;
            return;
        }
        if(root.left!=null&&count>0) dfs(root.left);
    }
}
