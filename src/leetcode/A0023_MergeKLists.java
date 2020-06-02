package leetcode;

import leetcode.structure.ListNode;

public class A0023_MergeKLists {
    /**
     合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

     示例:

     输入:
     [
       1->4->5,
       1->3->4,
       2->6
     ]
     输出: 1->1->2->3->4->4->5->6
     */

    /**
     *  分治法    先相邻2个合并  然后第一个和第三个合并  然后 第一个和第五个合并
     *  时间复杂度  O（n * logK）
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while (interval<lists.length){
            System.out.println("-----------");
            System.out.println("interval "+interval);
            for(int i=0;i<lists.length;i=interval*2+i){
                if(i+interval<lists.length) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                    System.out.println("merge "+i+" "+(i+interval));
                }
            }
            interval = interval*2;
        }
        return lists[0];
    }
    static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[13];
        for(int i=0;i<lists.length;i++){
            lists[i] = new ListNode();
        }
        A0023_MergeKLists.mergeKLists(lists);
    }
}
