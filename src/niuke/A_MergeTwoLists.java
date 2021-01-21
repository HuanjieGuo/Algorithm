package niuke;

import leetcode.structure.ListNode;

public class A_MergeTwoLists {
    // small -> large
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if(l1==null) return l2;
        else if(l2==null) return l1;
        //
        if(l1.val>l2.val) {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

}
