package top100;

import leetcode.structure.ListNode;

public class A0019_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        // 双指针
        ListNode p_ahead = head;
        ListNode p_behind = null;
        int count = 1;
        while (p_ahead!=null){
            p_ahead = p_ahead.next;
            count++;
            if(count-1>n)
                if(p_behind==null) p_behind = head;
                else p_behind = p_behind.next;
        }
        if(p_behind==null) return head.next;
        p_behind.next = p_behind.next.next;
        return head;
    }

}
