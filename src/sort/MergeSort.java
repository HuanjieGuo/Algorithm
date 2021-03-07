package sort;

import java.util.concurrent.ConcurrentSkipListSet;

public class MergeSort {
    int arr[];
    int tmp[];
    public void mergeSort(int arr[]) {
        this.arr = arr;
        tmp = new int[arr.length];
        partialMerge(0,arr.length-1);
    }

    void partialMerge(int left,int right){
        if(left>=right) return;
        int mid = (left+right)/2;
        // 递归分到剩下1
        partialMerge(left,mid);
        partialMerge(mid+1,right);
        // 合并排序
        merge(left,mid,right);
    }

    void merge(int left,int mid,int right){
        int tmp_idx = 0;
        // 左边有序起点
        int i = left;
        // 右边有序起点
        int j = mid+1;
        // 比较
        while (i<=mid&&j<=right)
            if(arr[i]>arr[j]) tmp[tmp_idx++] = arr[j++];
            else tmp[tmp_idx++] = arr[i++];
        // 剩余，两个while只有一个会执行
        while (i<=mid) tmp[tmp_idx++] = arr[i++];
        while (j<=right) tmp[tmp_idx++] = arr[j++];
        // 复制
        for(int k=0;k<right-left+1;k++)
            arr[left+k] = tmp[k];

    }

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        new MergeSort().mergeSort(arr);
        for(int i:arr)
            System.out.println(i);
    }
}
