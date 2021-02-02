package niuke;

import dataStructure.TreeNode;

/**
 *  find the common ancester
 */
public class A_LowestCommonAncestor {
    int ancestor = -1;
    // 1找到   0没找到
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return commonAncestor(root,o1,o2).val;
    }

    public TreeNode commonAncestor (TreeNode root, int o1, int o2) {
        if(root==null||root.val==o1||root.val==o2) return root;
        TreeNode left = commonAncestor(root.left,o1,o2);
        TreeNode right = commonAncestor(root.right, o1, o2);

        if(left==null&&right==null) return null;
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        System.out.println(new A_LowestCommonAncestor().lowestCommonAncestor(root,3,1));
    }



}
