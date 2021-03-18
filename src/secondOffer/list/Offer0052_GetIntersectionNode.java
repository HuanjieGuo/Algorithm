package secondOffer.list;

import leetcode.structure.ListNode;

/**
 输入两个链表，找出它们的第一个公共节点。
 */
public class Offer0052_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=p2){
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }
}
