package hot100;

import java.util.ArrayList;
import java.util.LinkedList;

public class A0056_Merge {
    int[][] intervals;
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][2];
        this.intervals = intervals;
        // 先按start排序
        quickSort(0, intervals.length-1);
        // 排序OK
        ArrayList<int[]> result = new ArrayList<>();
        Integer start = null;
        Integer end = null;
        for(int[] interval:intervals){
            if(start==null){
                start = interval[0];
                end = interval[1];
            }else {
                // 无交集
                if(end<interval[0]){
                    result.add(new int[]{start,end});
                    start = interval[0];
                    end = interval[1];
                }else
                    // 有交集,选终点最大
                    end = Math.max(end,interval[1]);
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][2]);
    }


    void quickSort(int left,int right){
        if(left>=right) return;
        int startPoint = left;
        int endPoint = right;
        int[] pivot = intervals[right];
        while (left<right){
            while (left<right&&intervals[left][0]<pivot[0]) left++;
            if (left<right) {
                intervals[right] = intervals[left];
                right--;
            }
            while (left<right&&intervals[right][0]>pivot[0]) right--;
            if(left<right) {
                intervals[left] = intervals[right];
                left++;
            }
        }
        intervals[left] = pivot;
        quickSort(startPoint,left-1);
        quickSort(left+1,endPoint);
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,4},{1,4}};
        new A0056_Merge().merge(ints);
    }
}
