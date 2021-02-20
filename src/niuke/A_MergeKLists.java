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
     * 合并2个的思路   K组用归并， 2个2个合并
     * @param lists
     * @return
     */
    ArrayList<ListNode> lists;
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size()==0||lists==null) return null;
        this.lists = lists;
        return mergeSubLists(0,lists.size()-1);

    }

    public ListNode mergeSubLists(int left,int right){
        if(left>=right) return lists.get(left);
        // 接下来的right -left > 1 有2条最起码
        int mid = (left+right)/2;
        ListNode l1 = mergeSubLists(left,mid);
        ListNode l2 = mergeSubLists(mid+1,right);
        return merge(l1,l2);
    }

    ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val>l2.val) {
            l2.next = merge(l1,l2.next);
            return l2;
        }else {
            l1.next = merge(l2,l1.next);
            return l1;
        }
    }


}
