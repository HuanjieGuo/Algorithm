/**

 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。



 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [20,9],
 [15,7]
 ]
 */
package offerAlgorithm.Offer_32_LevelOrder;
import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer_32_3_LeverOrder {
        /**
         队列广度搜索！
         题目要求隔行反向
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> retList = new ArrayList<>();
            // 空值判断
            if(root==null){
                return retList;
            }
            queue.add(root);
            boolean leftToRight = true;
            while (queue.size()!=0){
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for(int i=0;i<size;i++){
                    TreeNode treeNode = queue.poll();
                    // 控制反向
                    if(leftToRight) list.add(treeNode.val);
                    else list.add(0,treeNode.val);
                    if(treeNode.left!=null) queue.offer(treeNode.left);
                    if(treeNode.right!=null)queue.offer(treeNode.right);
                }
                retList.add(list);
                // 切换方向
                leftToRight = !leftToRight;
            }
            return retList;
        }
}
