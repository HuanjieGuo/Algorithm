package niuke;

import leetcode.structure.ListNode;

public class A_RemoveNthFromEnd {
    /**
     快指针先跑完， 这样子慢指针是倒数第k个
     slowLast指向慢指针前一个,慢指针前进1,k=k-1，k=n的话，slowLast = slowLast.next.next
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if(head==null) return null;
        int lastIndex = 1;
        ListNode fast = head;
        while (fast.next!=null){
            fast = fast.next;
            lastIndex++;
        }
        ListNode slowLast = null;
        ListNode slow = head;
        while (lastIndex!=n){
            lastIndex--;
            slowLast = slow;
            slow = slow.next;
        }
        if(slowLast==null) return head.next;
        slowLast.next = slowLast.next.next;
        return head;
    }
}
