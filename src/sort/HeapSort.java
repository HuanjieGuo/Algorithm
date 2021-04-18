package sort;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = new int[]{5,32,0,1,2,-1,40,30};
        heapSort.quickSort(nums,nums.length);
        for(int num:nums)System.out.println(num);
    }
    void quickSort(int[] tree, int n){
        buildHeap(tree,n);
        for(int i=n-1;i>=0;i--){
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }

    void buildHeap(int [] tree,int n){
        int lastIdx = n-1;
        int lastParent = (lastIdx-1)/2;
        for(int i=lastParent;i>=0;i--)
            heapify(tree,n,i);
    }

    void heapify(int[] tree,int n,int i){
        if(i>=n) return;
        int left = i*2+1;
        int right = i*2+2;
        int maxIdx = i;
        if(left<n&&tree[left]>tree[maxIdx]) maxIdx = left;
        if(right<n&&tree[right]>tree[maxIdx]) maxIdx = right;
        if(maxIdx!=i){
            swap(tree,maxIdx,i);
            heapify(tree,n,maxIdx);
        }
    }
    void swap(int[] tree,int i,int j){
        int tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }
}
