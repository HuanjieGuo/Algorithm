package niuke;

import leetcode.structure.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (count<k&&p!=null){
            count++;
            p = p.next;
        }
        if(count<k) return head;
        //
        ListNode pp = head;

        ListNode pre = null;
        ListNode next;
        while (pp!=p){
            next = pp.next;
            pp.next = pre;
            pre = pp;
            pp = next;
        }
        head.next = reverseKGroup(p,k);
        return pre;
    }


}
