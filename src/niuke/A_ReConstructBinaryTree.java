package niuke;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 示例1
 输入
 复制
 [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 返回值
 复制
 {1,2,5,3,4,6,7}
 */
public class A_ReConstructBinaryTree {
    Map<Integer,Integer> indexOfIn = new HashMap<>();
    int [] pre;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        this.pre = pre;

        int length_pre = pre.length;
        int length_in = in.length;

        for(int i=0;i<in.length;i++)
            indexOfIn.put(in[i],i);
        return buildTreeBI(0,length_pre-1,0,length_in-1);

    }

    TreeNode buildTreeBI(int preL,int preR,
                         int inL,int inR){
        if(preL>preR||inL>inR) return null;
        TreeNode treeNode = new TreeNode(pre[preL]);
        int pivot = indexOfIn.get(pre[preL]);
        treeNode.left = buildTreeBI(preL+1,(preL+1)+(pivot-1-inL)
                ,inL,pivot-1);
        treeNode.right = buildTreeBI((preL+1)+(pivot-1-inL)+1,preR,
                pivot+1,inR);
        return treeNode;
    }
}
