package secondOffer.array;

public class Offer0051_ReversePairs {
    /**
     * 暴力算法
     * 时间复杂度 O(N^2)
     * @param nums
     * @return
     */
    public int reversePairs_BF(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]>nums[j]) count++;
        return count;
    }

    /**
     归并计数
     */
    int[] nums;
    int[] tep;
    int count;
    public int reversePairs(int[] nums){
        this.nums = nums;
        tep = new int[nums.length];
        partial(0,nums.length-1);
        for(int num:tep) System.out.println(num);
        return count;
    }

    void partial(int left,int right){
        if(left>=right) return;
        int mid = (left+right)/2;
        partial(left,mid);
        partial(mid+1,right);
        merge(left,mid,right);
    }
    void merge(int left,int mid,int right){
        int l_idx = left;
        int r_idx = mid+1;
        int idx = 0;
        while (l_idx<=mid&&r_idx<=right){
            if(nums[l_idx]>nums[r_idx]){
                // 核心是这一句
                count += mid-l_idx+1;
                tep[idx++] = nums[r_idx++];
            }else tep[idx++] = nums[l_idx++];
        }
        while (l_idx<=mid) tep[idx++] = nums[l_idx++];
        while (r_idx<=right) tep[idx++] = nums[r_idx++];
        for(int i=0;i<idx;i++) nums[left+i] = tep[i];
    }
    public static void main(String[] args) {
        new Offer0051_ReversePairs().reversePairs(new int[]{7,5,6,4});
    }
}
