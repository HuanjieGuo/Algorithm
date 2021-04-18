package top100;

import leetcode.structure.ListNode;

public class A0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int p1_count = 0;
        int p2_count = 0;
        while (p1!=null){
            p1_count++;
            p1 = p1.next;
        }
        while (p2!=null){
            p2_count++;
            p2 = p2.next;
        }
        // l1 is the longest one
        if(p1_count<p2_count) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        // put it at the begining
        p1 = l1;
        p2 = l2;
        ListNode p1_last = null;
        boolean forward = false;
        while (p1!=null){
            int val = p1.val+(p2==null?0:p2.val)+(forward?1:0);
            forward = (val>=10);
            p1.val = val%10;
            p1_last = p1;
            p1 = p1.next;
            if(p2!=null) p2 = p2.next;
        }
        if(forward) p1_last.next = new ListNode(1);
        return l1;
    }
}
