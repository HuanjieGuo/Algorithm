package hot100;

public class A0075_SortColors {
    int[] nums;
    public void sortColors(int[] nums) {
        this.nums = nums;
        quickSort(0,nums.length-1);
        for(int i:nums) System.out.println(i);
    }
    void quickSort(int left,int right){
        if(left>=right) return;
        int start = left;
        int end = right;
        int pivot = nums[right];
        while (left<right){
            while (left<right&&nums[left]<=pivot)left++;
            if(left<right) {
                nums[right] = nums[left];
                right--;
            }
            while (left<right&&nums[right]>=pivot)right--;
            if(left<right){
                nums[left] = nums[right];
                left++;
            }
        }
        nums[left] = pivot;
        quickSort(start,left-1);
        quickSort(left+1,end);
    }

    public static void main(String[] args) {
        new A0075_SortColors().sortColors(new int[]{2,0,2,1,1,0});
    }
}
