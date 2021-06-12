package hot100;

import dataStructure.TreeNode;

public class A0098_IsValidBST {
    /**
     * 中序遍历为升序
     * @param root
     * @return
     */
    Integer last;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        inOrderSearch(root);
        return isValid;
    }
    void inOrderSearch(TreeNode node){
        if(node==null||!isValid) return;
        inOrderSearch(node.left);
        if(last==null) last = node.val;
        else {
            // 本处注意， 只设置为false，不要 isValid = node.val>last, 会出错
            if(node.val<=last) isValid = false;
            last = node.val;
        }
        inOrderSearch(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        System.out.println(new A0098_IsValidBST().isValidBST(node));
    }
}
