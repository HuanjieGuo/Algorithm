package offerAlgorithm;
import leetcode.structure.ListNode;

import java.util.Stack;

/**

 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



 示例 1：

 输入：head = [1,3,2]
 输出：[2,3,1]


 限制：

 0 <= 链表长度 <= 10000
 */
public class A_Offer_06_ReversePrint {
    /**
     * 链表反转
     * 重点！
     */
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        int n= 0;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            n = n + 1;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
