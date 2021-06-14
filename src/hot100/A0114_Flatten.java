package hot100;

import dataStructure.TreeNode;

public class A0114_Flatten {
    /**
     1. 如果左子树不为空
     2. 找到左子树最右边的节点
     3. 节点右节点接入到左子树最右节点
     4. 节点右子树等于左子树
     5. 左子树置空
     6. root = root.right
     */
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left!=null){
            // 找左子树最右节点
            TreeNode mostRightInLeft = root.left;
            while (mostRightInLeft.right!=null)
                mostRightInLeft = mostRightInLeft.right;
            // 左子树最右节点拼接上右子树
            mostRightInLeft.right = root.right;
            // 左子树迁移到右子树
            root.right = root.left;
            // 左子树清空
            root.left = null;
        }
        // 递归
        flatten(root.right);
    }
    TreeNode pre;
    public void flatten_backorder(TreeNode root){
        if(root==null) return;
        // 右 -> 左 -> 本节点
        flatten_backorder(root.right);
        flatten_backorder(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
