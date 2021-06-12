package hot100;

import dataStructure.TreeNode;

public class A0101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode a,TreeNode b){
        if(a==null&&b==null) return true;
        if(a==null||b==null) return false;
        return a.val==b.val
                &&compare(a.left,b.right)
                &&compare(a.right,b.left);
    }
}
