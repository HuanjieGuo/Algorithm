package niuke;


import java.awt.*;
import java.util.*;

public class QuickSort {
    public int[] mySort(int[] arr) {
        // write code here
        quickSortNew(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right) {
        int init_left = left;
        int init_right = right;
        if (left >= right) return;
        int pivot = arr[right];
        while (left < right) {
            // left
            while (arr[left] < pivot && left < right) left++;
            if (left != right) {
                arr[right] = arr[left];
                // left stop
                // right --
                right--;
            }
            // right
            while (arr[right] > pivot && left < right) right--;
            if (left != right) {
                arr[left] = arr[right];
                // left move, right stop
                left++;
            }
        }
        arr[left] = pivot;
        quickSort(arr, init_left, left - 1);
        quickSort(arr, left + 1, init_right);
    }


    public static void main(String[] args) {
        int[] a = new int[]{4, 23, 5, 1, 2, 3, 5, 2, 35, 18, 15};
        QuickSort quickSort = new QuickSort();
        quickSort.mySort(a);
        String str = "";
        for (int num : a)
            str += num + " ";
        System.out.println(str);
    }

    void quickSortNew(int arr[],int left,int right){
        if(left>=right) return;
        int start = left;
        int end = right;
        int pivot = arr[right];
        while (left<right){
            // 左边先
            while (arr[left]<pivot&&left<right) left++;
            if(left!=right){
                arr[right] = arr[left];
                right--;
            }
            if(left>=right) break;
            // 右边
            while (arr[right]>pivot&&left<right) right--;
            if(left!=right) {
                arr[left] = arr[right];
                left++;
            }
        }
        arr[left] = pivot;
        quickSortNew(arr,start,left-1);
        quickSortNew(arr,left+1,end);
    }

}
