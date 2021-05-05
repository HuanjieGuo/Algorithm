package hot100;

import leetcode.structure.ListNode;

public class A0023_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length==0) return null;
        if(length==1) return lists[0];
        if(length==2) return mergeTwoList(lists[0],lists[1]);
        int mid = length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i=0;i<mid;i++)  l1[i] = lists[i];
        ListNode[] l2 = new ListNode[length-mid];
        for(int i=mid;i<length;i++) l2[i-mid] = lists[i];
        return mergeTwoList(mergeKLists(l1),mergeKLists(l2));
    }
    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val) {
            list1.next = mergeTwoList(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoList(list2.next,list1);
            return list2;
        }
    }
}
