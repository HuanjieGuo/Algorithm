package offerAlgorithm;

import leetcode.structure.ListNode;

/**
 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

 示例1：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 限制：

 0 <= 链表长度 <= 1000

 */
public class A_Offer_25_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
            return l1==null?l2:l1;
         if(l1.val<l2.val){
             // 本处l1符合，直接跳过l1, 用l1.next
             l1.next = mergeTwoLists(l1.next,l2);
             return l1;
         }else {
             l2.next = mergeTwoLists(l1,l2.next);
             return l2;
         }
    }
}
