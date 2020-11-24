package offerAlgorithm;

import dataStructure.TreeNode;

/**
 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

     1
    / \
   2   2
    \   \
    3    3

  

 示例 1：

 输入：root = [1,2,2,3,4,4,3]
 输出：true
 示例 2：

 输入：root = [1,2,2,null,3,null,3]
 输出：false
  

 限制：

 0 <= 节点个数 <= 1000

 */
public class A_Offer_28_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode tree1,TreeNode tree2){
        if(tree1==null&&tree2==null)
            return true;
        if(tree1==null||tree2==null)
            return false;
        return tree1.val==tree2.val
                &&compare(tree1.left,tree2.right)
                &&compare(tree1.right,tree2.left);
    }

    public static void main(String[] args) {
    }
}
