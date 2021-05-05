package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0015_ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if(nums[left]+nums[right]+nums[i]==0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left<right&&nums[left]==nums[left-1]) left++;
                    while (left<right&&nums[right]==nums[right+1]) right--;
                }else if(nums[left]+nums[right]+nums[i]<0)left++;
                else right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
