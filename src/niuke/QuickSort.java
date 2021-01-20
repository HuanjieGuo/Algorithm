package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    int[] rank(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    /**
     https://www.bilibili.com/video/BV1at411T75o
     * @param arr
     * @param left
     * @param right
     */
    void quickSort(int arr[],int left,int right){
        int start = left;
        int end = right;

        if(right-left<=0) return;
        // 选取最左作为pivot
        int pivot = arr[left];
        while (true){
            // 右边动
            while (arr[right]>=pivot&&left<right) right--;
            if(left<right) arr[left] = arr[right];
            // 左边动
            while (arr[left]<=pivot&&left<right)left++;
            if(left<right) arr[right] = arr[left];
            if(left==right) break;
        }
        // 如果需要题目是找第k大， 本处判断left坐标，， 提前结束递归！！！！

        // 空余位置给pivot值
        arr[left] = pivot;
        quickSort(arr,start,left-1);
        quickSort(arr,left+1,end);
    }

    public static void main(String[] args) {
        int[] arr = new QuickSort().rank(new int[]{5,3,6,9,1,0,-1,2,3,5,10,-2,-3});
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:arr)
            list.add(i);
        System.out.println(list);
    }
}
