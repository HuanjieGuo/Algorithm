package offerAlgorithm.Offer_32_LevelOrder;

import dataStructure.TreeNode;
import leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

  

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
  

 提示：

 节点总数 <= 1000

 */
public class Offer_32_2_LevelOrder {

    /**
     队列广度搜索！
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> retList = new ArrayList<>();
        // 空值判断
        if(root==null){
            return retList;
        }
        queue.add(root);
        while (queue.size()!=0){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null) queue.offer(treeNode.left);
                if(treeNode.right!=null)queue.offer(treeNode.right);
            }
            retList.add(list);
        }
        return retList;
    }

}
