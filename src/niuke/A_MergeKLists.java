package niuke;

import leetcode.structure.ListNode;

import java.util.ArrayList;

/**
 题目描述
 合并\ k k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
 示例1
 输入
 复制
 [{1,2,3},{4,5,6,7}]
 返回值
 复制
 {1,2,3,4,5,6,7}

 */

public class A_MergeKLists {
    /**
     * 合并2个的思路  执行N次
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode merge = null;
        for(ListNode list:lists)
           merge =  mergeTwo(merge,list);
        return merge;
    }

    ListNode mergeTwo(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if (list2==null) return list1;
        if(list1.val<list2.val) {
            list1.next = mergeTwo(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwo(list2.next,list1);
            return list2;
        }


    }
}
