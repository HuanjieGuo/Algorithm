package offerAlgorithm;

import java.util.Random;

public class A_Ranking {
    /**
     * 插入排序
     * 1.保存当前值
     * 2.和前面比较，某个值>当前值，把某个值后移1位
     * 3.最后插入当前值
     * O(n^2)
     *
     * @param arr
     */
    static void insertion_sort(int arr[]) {
        if (arr.length < 2) return;
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = temp;
        }
    }

    /**
     * 冒泡排序
     * O(n^2)
     1. 循环n-1次
     2. 每次n和n+1对比 如果a[n]>a[n+1] 换位置
     * @param arr
     */
    static void bubbleSort(int arr[]){
        for(int t=0;t<arr.length-1;t++)
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
    }

    /**
     O(nlogn) - Average case running time
     O(n^2) worst case running time
     in place
     https://www.bilibili.com/video/BV1at411T75o/?spm_id_from=333.788.videocard.0
     * @param arr
     */
    static void quickSort(int arr[]){
        quickSort(arr,0, arr.length-1);
    }
    static  void quickSort(int arr[],int start,int end){
        if(start>=end) return;
        int pivot = arr[end];
        int left = start;
        int right = end;
        boolean rightIsNull = true;
        while (left<right){
            if(rightIsNull){
                // 移动左指针
                if(arr[left]>pivot){
                    arr[right] = arr[left];
                    right--;
                    rightIsNull = !rightIsNull;
                }else left++;
            }else {
                // 移动右指针
                if(arr[right]<pivot){
                    arr[left] = arr[right];
                    left++;
                    rightIsNull = !rightIsNull;
                }else right--;
            }
        }
        // pivot放置到空的位置 left right都行
        arr[left] = pivot;
        quickSort(arr,start,left-1);
        quickSort(arr,left+1,end);
    }

    public static void main(String[] args) {
//        int arr[] = new int[10000];
//        Random random = new Random();
//        for(int i=0;i<10000;i++){
//            arr[i] = random.nextInt(10000);
//        }
        int arr[] = new int[]{10,8,6,9,4,5,7,3,2,1};

        // 快排， 100000  30ms
        // 冒泡， 100000  21454ms
        // 插入， 100000  911ms
        Long time = System.currentTimeMillis();
        insertion_sort(arr);
        System.out.println(System.currentTimeMillis()-time);

        String str = "";
        for(int ar:arr)
            str = str + ar + " ";
        System.out.println(str);

    }
}
