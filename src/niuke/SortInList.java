package niuke;

import leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortInList {
    public ListNode sortInList (ListNode head) {
        ListNode iter = head;
        // write code here
        List<Integer> arrayList = new ArrayList<>();
        while (iter!=null){
            arrayList.add(iter.val);
            iter = iter.next;
        }
        Collections.sort(arrayList);
        iter = head;
        for(int i=0;i<arrayList.size();i++){
            iter.val = arrayList.get(i);
            iter = iter.next;
        }
        return head;
    }


}
