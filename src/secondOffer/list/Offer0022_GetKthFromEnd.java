package secondOffer.list;

import leetcode.structure.ListNode;

/**
 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 */
public class Offer0022_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null) return null;
        ListNode p_ahead = head;
        ListNode p_behind = head;
        int count = 0;
        while (p_ahead!=null){
            if(count>=k) p_behind = p_behind.next;
            p_ahead = p_ahead.next;
            count++;
        }
        return p_behind;
    }
}
