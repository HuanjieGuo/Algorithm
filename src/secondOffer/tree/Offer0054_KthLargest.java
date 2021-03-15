package secondOffer.tree;

import dataStructure.TreeNode;

public class Offer0054_KthLargest {
    int count;
    Integer num = null;
    // 访问顺序 右-> 中-> 左
    public int kthLargest(TreeNode root, int k) {
        count = k;
        search(root);
        return num;
    }

    void search(TreeNode node){
        // 已找到，停止递归
        if(num!=null||node==null) return;
        // 先找右
        search(node.right);
        count--;
        if(count==0) num = node.val;
        // 再找左
        search(node.left);
    }
}
